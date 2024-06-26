package org.example.first.service.api.controller;

import io.swagger.annotations.*;
import jakarta.validation.Valid;
import org.example.first.service.api.model.IngredientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/ingredient")
@Api(value = "Ingredient Controller", tags = {"Ingredient"})
public interface IngredientApi {

    @ApiOperation(value = "Get all Ingredients", nickname = "getIngredients", notes = "Get all Ingredients", response = IngredientDto.class, responseContainer = "List", tags = {"Ingredient"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response - returns an array of `IngredientDTO` entities.", response = IngredientDto.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Error.class)
    })
    @GetMapping(value = "/all", produces = {"application/json"})
    ResponseEntity<List<IngredientDto>> getIngredients();

    @ApiOperation(value = "Find Ingredient by ID", nickname = "getIngredientById", notes = "Find Ingredient by ID", response = IngredientDto.class, tags = {"Ingredient"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response - returns a `IngredientDTO` entity.", response = IngredientDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Ingredient not found", response = Error.class)
    })
    @GetMapping(value = "/{id}", produces = {"application/json"})
    ResponseEntity<IngredientDto> getIngredientById(@ApiParam(value = "ID of the ingredient to retrieve", required = true) @PathVariable("id") Integer ingredientId);

    @ApiOperation(value = "Create Ingredient", nickname = "createIngredient", notes = "Create a new Ingredient", response = IngredientDto.class, tags = {"Ingredient"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ingredient created successfully", response = IngredientDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class)
    })
    @PostMapping(value = "/", produces = {"application/json"})
    ResponseEntity<IngredientDto> createIngredient(@ApiParam(value = "Ingredient object to store in database", required = true) @Valid @RequestBody IngredientDto ingredientDto);

    @ApiOperation(value = "Update Ingredient", nickname = "updateIngredient", notes = "Update an existing Ingredient", response = IngredientDto.class, tags = {"Ingredient"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ingredient updated successfully", response = IngredientDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Ingredient not found", response = Error.class)
    })
    @PutMapping(value = "/{id}", produces = {"application/json"})
    ResponseEntity<IngredientDto> updateIngredient(@ApiParam(value = "ID of the ingredient to update", required = true) @PathVariable("id") Integer ingredientId, @ApiParam(value = "Updated ingredient object", required = true) @RequestBody IngredientDto ingredientDto);

    @ApiOperation(value = "Delete Ingredient", nickname = "deleteIngredient", notes = "Delete an existing Ingredient", tags = {"Ingredient"})
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Ingredient deleted successfully"),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Ingredient not found", response = Error.class)
    })
    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    ResponseEntity<Void> deleteIngredient(@ApiParam(value = "ID of the ingredient to delete", required = true) @PathVariable("id") Integer ingredientId);
}
