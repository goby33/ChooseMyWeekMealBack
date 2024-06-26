package org.example.first.service.api.controller;

import io.swagger.annotations.*;
import jakarta.validation.Valid;
import org.example.first.service.api.model.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/category")
@Api(value = "Category", tags = {"Category"})
public interface CategoryApi {

    @ApiOperation(value = "Get all Categories", nickname = "getCategories", notes = "Get all Categories", response = CategoryDto.class, responseContainer = "List", tags = {"Category"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response - returns an array of `CategoryDTO` entities.", response = CategoryDto.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Error.class)
    })
    @GetMapping(value = "/all", produces = {"application/json"})
    ResponseEntity<List<CategoryDto>> getCategories();

    @ApiOperation(value = "Find Category by ID", nickname = "getCategoryById", notes = "Find Category by ID", response = CategoryDto.class, tags = {"Category"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response - returns a `CategoryDTO` entity.", response = CategoryDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Category not found", response = Error.class)
    })
    @GetMapping(value = "/{id}", produces = {"application/json"})
    ResponseEntity<CategoryDto> getCategoryById(@ApiParam(value = "ID of the category to retrieve", required = true) @PathVariable("id") Integer categoryId);

    @ApiOperation(value = "Create Category", nickname = "createCategory", notes = "Create a new Category", response = CategoryDto.class, tags = {"Category"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Category created successfully", response = CategoryDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class)
    })
    @PostMapping(value = "/", produces = {"application/json"})
    ResponseEntity<CategoryDto> createCategory(@ApiParam(value = "Category object to store in database", required = true) @Valid @RequestBody CategoryDto categoryDto);

    @ApiOperation(value = "Update Category", nickname = "updateCategory", notes = "Update an existing Category", response = CategoryDto.class, tags = {"Category"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category updated successfully", response = CategoryDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Category not found", response = Error.class)
    })
    @PutMapping(value = "/{id}", produces = {"application/json"})
    ResponseEntity<CategoryDto> updateCategory(@ApiParam(value = "ID of the category to update", required = true) @PathVariable("id") Integer categoryId, @ApiParam(value = "Updated category object", required = true) @RequestBody CategoryDto categoryDto);

    @ApiOperation(value = "Delete Category", nickname = "deleteCategory", notes = "Delete an existing Category", tags = {"Category"})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Category deleted successfully"),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Category not found", response = Error.class)
    })
    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    ResponseEntity<Void> deleteCategory(@ApiParam(value = "ID of the category to delete", required = true) @PathVariable("id") Integer categoryId);
}

