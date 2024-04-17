package com.jersson.arrivasplata.swtvap.api.auth.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jersson.arrivasplata.swtvap.api.auth.model.AuthRefreshTokenRequest;
import com.jersson.arrivasplata.swtvap.api.auth.model.SignUpRequest;
import com.jersson.arrivasplata.swtvap.api.auth.repository.RoleRepository;
import com.jersson.arrivasplata.swtvap.api.auth.request.AuthenticationRequest;
import com.jersson.arrivasplata.swtvap.api.auth.services.BlackListService;
import com.jersson.arrivasplata.swtvap.api.auth.services.CustomUserDetailsService;
import com.jersson.arrivasplata.swtvap.api.common.model.Role;
import com.jersson.arrivasplata.swtvap.api.common.model.User;
import com.jersson.arrivasplata.swtvap.api.common.repository.UserRepository;
import com.jersson.arrivasplata.swtvap.utils.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BlackListService blackListService;


    @Autowired
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        return new ResponseEntity<>(new JwtUtil().generateToken(authentication), HttpStatus.OK);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody AuthRefreshTokenRequest request) {
        String requestToken = request.getRefreshToken();
        if (new JwtUtil().validateToken(requestToken)) {
            if (blackListService.isBlacklisted(requestToken)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is blacklisted");
            }

            UserDetails userDetails = userDetailsService.loadUserByUsername(new JwtUtil().extractUsername(requestToken));
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>(new JwtUtil().generateToken(authentication), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logoutUser(@RequestParam String redirectUri, @RequestParam String idToken, @RequestParam String accessToken) {
        // Validate the refresh token
        if(!blackListService.isBlacklisted(accessToken)){
            blackListService.add(accessToken, null);
        }
        return ResponseEntity.ok("Logged out successfully");
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpDto){
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Optional<Role> optionalRole = roleRepository.findByName("ROLE_USER");
        if (optionalRole.isPresent()) {
            Set<Role> roles = new HashSet<>();
            roles.add(optionalRole.get());
            user.setRoles(roles);
        } else {
            return new ResponseEntity<>("Role not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}