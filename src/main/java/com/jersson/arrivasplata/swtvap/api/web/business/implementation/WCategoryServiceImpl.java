package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WCategoryService;
import com.jersson.arrivasplata.swtvap.api.web.model.WCategory;
import com.jersson.arrivasplata.swtvap.api.web.repository.WCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WCategoryServiceImpl implements WCategoryService {

    private final WCategoryRepository WCategoryRepository;

    @Autowired
    public WCategoryServiceImpl(WCategoryRepository WCategoryRepository) {
        this.WCategoryRepository = WCategoryRepository;
    }

    @Override
    public List<WCategory> getAllCategories() {
        return WCategoryRepository.findAll();
    }

}
