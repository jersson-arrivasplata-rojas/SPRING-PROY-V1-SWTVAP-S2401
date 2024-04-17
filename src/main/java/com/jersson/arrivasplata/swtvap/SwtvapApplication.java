package com.jersson.arrivasplata.swtvap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jersson.arrivasplata.swtvap.utils.SecretKeyGenerator;

@SpringBootApplication
public class SwtvapApplication {

	public static void main(String[] args) throws Exception {
		System.out.println(SecretKeyGenerator.generateSecretKey());

		SpringApplication.run(SwtvapApplication.class, args);
	}

	/*@Bean
	public ApplicationRunner applicationRunner() {
		return args -> {
			// Aquí va el código que quieres ejecutar después de que la aplicación se haya iniciado
			System.out.println("La aplicación se ha iniciado correctamente.");

			ValidateToken.validate();
		};
	}*/
}
