package org.example.first.service.api.controller;

import io.swagger.annotations.*;
import jakarta.validation.Valid;
import org.example.first.service.api.model.RecipeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/recipe")
@Api(value = "Recipe Controller", tags = {"Recipe"})
public interface RecipeApi {

    @ApiOperation(value = "Get all Recipes", nickname = "getRecipes", notes = "Get all Recipes", response = RecipeDto.class, responseContainer = "List", tags = {"Recipe"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response - returns an array of `RecipeDTO` entities.", response = RecipeDto.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Error.class)
    })
    @GetMapping(value = "/all", produces = {"application/json"})
    ResponseEntity<List<RecipeDto>> getRecipes();

    @ApiOperation(value = "Find Recipe by ID", nickname = "getRecipeById", notes = "Find Recipe by ID", response = RecipeDto.class, tags = {"Recipe"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response - returns a `RecipeDTO` entity.", response = RecipeDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Recipe not found", response = Error.class)
    })
    @GetMapping(value = "/{id}", produces = {"application/json"})
    ResponseEntity<RecipeDto> getRecipeById(@ApiParam(value = "ID of the recipe to retrieve", required = true) @PathVariable("id") Integer recipeId);

    @ApiOperation(value = "Create Recipe", nickname = "createRecipe", notes = "Create a new Recipe", response = RecipeDto.class, tags = {"Recipe"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Recipe created successfully", response = RecipeDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class)
    })
    @PostMapping(value = "/", produces = {"application/json"})
    ResponseEntity<RecipeDto> createRecipe(@ApiParam(value = "Recipe object to store in database", required = true) @Valid @RequestBody RecipeDto recipeDto);

    @ApiOperation(value = "Update Recipe", nickname = "updateRecipe", notes = "Update an existing Recipe", response = RecipeDto.class, tags = {"Recipe"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Recipe updated successfully", response = RecipeDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Recipe not found", response = Error.class)
    })
    @PutMapping(value = "/{id}", produces = {"application/json"})
    ResponseEntity<RecipeDto> updateRecipe(@ApiParam(value = "ID of the recipe to update", required = true) @PathVariable("id") Integer recipeId, @ApiParam(value = "Updated recipe object", required = true) @RequestBody RecipeDto recipeDto);

    @ApiOperation(value = "Delete Recipe", nickname = "deleteRecipe", notes = "Delete an existing Recipe", tags = {"Recipe"})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Recipe deleted successfully"),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Recipe not found", response = Error.class)
    })
    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    ResponseEntity<Void> deleteRecipe(@ApiParam(value = "ID of the recipe to delete", required = true) @PathVariable("id") Integer recipeId);
}

