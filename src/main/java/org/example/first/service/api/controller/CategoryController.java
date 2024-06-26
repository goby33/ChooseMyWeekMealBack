package org.example.first.service.api.controller;

import org.example.first.service.api.model.CategoryDto;
import org.example.first.service.business.contrat.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<CategoryDto> getCategoryById(Integer categoryId) {
        CategoryDto category = categoryService.findById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
        CategoryDto category = categoryService.create(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryDto> updateCategory(Integer categoryId, CategoryDto categoryDto) {
        CategoryDto category = categoryService.update(categoryId, categoryDto);
        return new ResponseEntity<>(category, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> deleteCategory(Integer categoryId) {
        categoryService.delete(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
