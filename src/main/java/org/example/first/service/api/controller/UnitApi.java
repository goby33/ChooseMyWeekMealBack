package org.example.first.service.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.example.first.service.api.model.UnitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/v1/unit")
@Api(value = "Unit Controller", tags = { "Unit" })
public interface UnitApi {

    @ApiOperation(value = "Get all Units", nickname = "getUnits", notes = "Get all Units", response = UnitDto.class, responseContainer = "List", tags = { "Unit" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response - returns an array of `UnitDTO` entities.", response = UnitDto.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 500, message = "Internal server error", response = Error.class)
    })
    @GetMapping(value = "/all", produces = { "application/json" })
    ResponseEntity<List<UnitDto>> getUnits();


    //getUnitById


    @ApiOperation(value = "Find Unit by ID", nickname = "getUnitById", notes = "Find Unit by ID", response = UnitDto.class, tags = { "Unit" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response - returns a `UnitDTO` entity.", response = UnitDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Unit not found", response = Error.class)
    })
    @GetMapping(value = "/{id}", produces = { "application/json" })
    ResponseEntity<UnitDto> getUnitById(@PathVariable("id") Integer unitId);

    @ApiOperation(value = "Create Unit", nickname = "createUnit", notes = "Create a new Unit", response = UnitDto.class, tags = { "Unit" })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Unit created successfully", response = UnitDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class)
    })
    @PostMapping(value = "/", produces = { "application/json" })
    ResponseEntity<UnitDto> createUnit(@Valid @RequestBody UnitDto unitDto);

    @ApiOperation(value = "Update Unit", nickname = "updateUnit", notes = "Update an existing Unit", response = UnitDto.class, tags = { "Unit" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Unit updated successfully", response = UnitDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Unit not found", response = Error.class)
    })
    @PutMapping(value = "/{id}", produces = { "application/json" })
    ResponseEntity<UnitDto> updateUnit(@PathVariable("id") Integer unitId, @RequestBody UnitDto unitDto);

    @ApiOperation(value = "Delete Unit", nickname = "deleteUnit", notes = "Delete an existing Unit", tags = { "Unit" })
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Unit deleted successfully"),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Unit not found", response = Error.class)
    })
    @DeleteMapping(value = "/{id}", produces = { "application/json" })
    ResponseEntity<Void> deleteUnit(@PathVariable("id") Integer unitId);
}
