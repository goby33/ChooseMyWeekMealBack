package org.example.first.service.business.contrat;

import org.example.first.service.api.model.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto findById(Integer categoryId);

    CategoryDto create(CategoryDto categoryDto);

    CategoryDto update(Integer categoryId, CategoryDto categoryDto);

    void delete(Integer categoryId);
}
