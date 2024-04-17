package com.jersson.arrivasplata.swtvap.api.inventory.business.implementation;

import com.jersson.arrivasplata.swtvap.api.inventory.business.service.CategoryService;
import com.jersson.arrivasplata.swtvap.api.inventory.enums.Status;
import com.jersson.arrivasplata.swtvap.api.inventory.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.common.model.Category;
import com.jersson.arrivasplata.swtvap.api.inventory.repository.CategoryCatalogRepository;
import com.jersson.arrivasplata.swtvap.api.inventory.repository.CategoryRepository;
import com.jersson.arrivasplata.swtvap.api.inventory.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryCatalogRepository categoryCatalogRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryCatalogRepository categoryCatalogRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryCatalogRepository = categoryCatalogRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CustomException("Category not found with id: " + id));
    }

    public Category createCategory(Category category) {
        // Lógica para crear una nueva categoría
        if (category.getName() == null || category.getName().isEmpty()) {
            throw new CustomException("Category name is required.");
        }
        // Resto de la lógica para crear una categoría
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        // Lógica para actualizar una categoría
        if (category.getName() == null || category.getName().isEmpty()) {
            throw new CustomException("Category name is required.");
        }
        // Resto de la lógica para actualizar una categoría
        return categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (!categoryOptional.isPresent()) {
            throw new CustomException("Category not found with id: " + id);
        }

        // Resto de la lógica para eliminar un catalogo
        Category category = categoryOptional.get();

        //categoryCatalogRepository.deleteByCatalogCatalogId(category.getCategoryId());

        category.setStatus(Status.INACTIVE);
        category.setDeletedAt(Common.builder().build().getCurrentDate());
        categoryRepository.save(category);
    }

    public Category getCategoryByName(String name) {
        // Implementación para recuperar la categoría por nombre desde el repositorio
        return categoryRepository.findByName(name);
    }
}
