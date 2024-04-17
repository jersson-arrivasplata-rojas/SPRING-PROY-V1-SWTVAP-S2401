package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WParameterService;
import com.jersson.arrivasplata.swtvap.api.web.model.WParameter;
import com.jersson.arrivasplata.swtvap.api.web.repository.WParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class WParameterServiceImpl implements WParameterService {
    private final WParameterRepository WParameterRepository;

    @Autowired
    public WParameterServiceImpl(WParameterRepository WParameterRepository) {
        this.WParameterRepository = WParameterRepository;
    }

    public WParameter getStructureByCode(String code) {
        Optional<WParameter> root = WParameterRepository.findByCode(code).stream().findFirst();
        if(root.isPresent()) {
            addChildrenRecursive(root.get());
        }
        return root.orElse(null);
    }

    private void addChildrenRecursive(WParameter parent) {
        List<WParameter> children = WParameterRepository.findByParentId(parent.getId());
        parent.setChildren(new HashSet<>(children));
        for(WParameter child : children) {
            addChildrenRecursive(child);
        }
    }
}
