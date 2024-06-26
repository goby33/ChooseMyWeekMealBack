package org.example.first.service.business.implementation;

import org.example.first.service.api.model.CategoryDto;
import org.example.first.service.client.entity.Category;
import org.example.first.service.client.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllSuccess() {
        Category category1 = new Category();
        category1.setName("Category1");
        Category category2 = new Category();
        category2.setName("Category2");
        List<Category> listCategory = List.of(category1, category2);

        when(categoryRepository.findAll()).thenReturn(listCategory);

        // When
        List<CategoryDto> categoryDtos = categoryServiceImpl.findAll();

        //then
        assertEquals(2, categoryDtos.size());
        assertEquals("Category1", categoryDtos.get(0).getName());
        assertEquals("Category2", categoryDtos.get(1).getName());
        verify(categoryRepository, Mockito.times(1)).findAll();
    }

    //public List<CategoryDto> findAll();

    //public CategoryDto findById(Integer categoryId);

   // public CategoryDto create(CategoryDto categoryDto);

   // public CategoryDto update(Integer categoryId, CategoryDto categoryDto);

    //public void delete(Integer categoryId);

    @Test
    void testFindByIdSuccess() {
        Category category = new Category();
        category.setName("Category1");

        when(categoryRepository.findById(1)).thenReturn(java.util.Optional.of(category));

        // When
        CategoryDto categoryDto = categoryServiceImpl.findById(1);

        //then
        assertEquals("Category1", categoryDto.getName());
        verify(categoryRepository, Mockito.times(1)).findById(1);
    }

    @Test
    void testCreateSuccess() {
        CategoryDto categoryDto = new CategoryDto(0, "Category1");

        Category category = new Category();
        category.setName("Category1");

        when(categoryRepository.save(category)).thenReturn(category);

        // When
        CategoryDto categoryDtoResult = categoryServiceImpl.create(categoryDto);

        //then
        assertEquals("Category1", categoryDtoResult.getName());
        verify(categoryRepository, Mockito.times(1)).save(category);
    }

    @Test
    void testUpdateSuccess() {
        Category category = new Category();
        category.setName("Category1");

        when(categoryRepository.findById(1)).thenReturn(java.util.Optional.of(category));

        CategoryDto categoryDto = new CategoryDto(0, "Category2");

        when(categoryRepository.save(category)).thenReturn(category);

        // When
        CategoryDto categoryDtoResult = categoryServiceImpl.update(1, categoryDto);

        //then
        assertEquals("Category2", categoryDtoResult.getName());
        verify(categoryRepository, Mockito.times(1)).findById(1);
        verify(categoryRepository, Mockito.times(1)).save(category);
    }

    @Test
    void testDeleteSuccess() {
        // When
        categoryServiceImpl.delete(1);

        //then
        verify(categoryRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    void testUpdateNotFound() {
        when(categoryRepository.findById(1)).thenReturn(java.util.Optional.empty());

        CategoryDto categoryDto = new CategoryDto(1, "Category2");

        // When
        CategoryDto categoryDtoResult = categoryServiceImpl.update(1, categoryDto);

        //then
        assertNull(categoryDtoResult);
        verify(categoryRepository, Mockito.times(1)).findById(1);
        verify(categoryRepository, Mockito.times(0)).save(null);
    }

    @Test
    void testFindByIdNotFound() {
        when(categoryRepository.findById(1)).thenReturn(java.util.Optional.empty());

        // When
        CategoryDto categoryDto = categoryServiceImpl.findById(1);

        //then
        assertNull(categoryDto);
        verify(categoryRepository, Mockito.times(1)).findById(1);
    }

    @Test
    void testFindAllEmpty() {
        when(categoryRepository.findAll()).thenReturn(List.of());

        // When
        List<CategoryDto> categoryDtos = categoryServiceImpl.findAll();

        //then
        assertEquals(0, categoryDtos.size());
        verify(categoryRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testDeleteNotFound() {
        // When
        categoryServiceImpl.delete(1);

        //then
        verify(categoryRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    void testCreateNull() {
        CategoryDto categoryDto = new CategoryDto(1, "Category1");

        Category category = new Category();
        category.setName("Category1");

        when(categoryRepository.save(category)).thenReturn(null);

        // When
        CategoryDto categoryDtoResult = categoryServiceImpl.create(categoryDto);

        //then
        assertNull(categoryDtoResult);
        verify(categoryRepository, Mockito.times(1)).save(category);
    }

    @Test
    void testCreateEmpty() {
        CategoryDto categoryDto = new CategoryDto(1, "Category1");

        Category category = new Category();
        category.setName("Category1");

        when(categoryRepository.save(category)).thenReturn(new Category());

        // When
        CategoryDto categoryDtoResult = categoryServiceImpl.create(categoryDto);

        //then
        assertEquals(null, categoryDtoResult);
        verify(categoryRepository, Mockito.times(1)).save(category);
    }

    @Test
    void testUpdateNull() {
        Category category = new Category();
        category.setName("Category1");

        when(categoryRepository.findById(1)).thenReturn(java.util.Optional.of(category));

        CategoryDto categoryDto = new CategoryDto(1, "Category2");

        when(categoryRepository.save(category)).thenReturn(null);

        // When
        CategoryDto categoryDtoResult = categoryServiceImpl.update(1, categoryDto);

        //then
        assertNull(categoryDtoResult);
        verify(categoryRepository, Mockito.times(1)).findById(1);
        verify(categoryRepository, Mockito.times(1)).save(category);
    }
}
