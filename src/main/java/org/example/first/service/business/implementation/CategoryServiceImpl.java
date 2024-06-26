package org.example.first.service.business.implementation;

import org.example.first.service.api.model.CategoryDto;
import org.example.first.service.business.contrat.CategoryService;
import org.example.first.service.client.entity.Category;
import org.example.first.service.client.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category -> new CategoryDto(category.getId(), category.getName())).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Integer categoryId) {
        return categoryRepository.findById(categoryId).map(category -> new CategoryDto(category.getId(), category.getName())).orElse(null);
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return new CategoryDto(category.getId(), category.getName());
    }

    @Override
    public CategoryDto update(Integer categoryId, CategoryDto categoryDto) {
        return categoryRepository.findById(categoryId).map(category -> {
            category.setName(categoryDto.getName());
            categoryRepository.save(category);
            return new CategoryDto(category.getId(), category.getName());
        }).orElse(null);
    }

    @Override
    public void delete(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
