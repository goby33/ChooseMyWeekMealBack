package org.example.first.service.api.controller;

import org.example.first.service.api.model.UnitDto;
import org.example.first.service.business.contrat.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UnitController implements UnitApi{

    @Autowired
    private UnitService unitService;

    @Override
    public ResponseEntity<List<UnitDto>> getUnits() {
        List<UnitDto> units = unitService.findAll();
        return new ResponseEntity<>(units, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<UnitDto> getUnitById(Integer unitId) {
        UnitDto unit = unitService.findById(unitId);
        return new ResponseEntity<>(unit, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<UnitDto> createUnit(UnitDto unitDto) {
        UnitDto unit = unitService.create(unitDto);
        return new ResponseEntity<>(unit, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UnitDto> updateUnit(Integer unitId, UnitDto unitDto) {
        UnitDto unit = unitService.update(unitId, unitDto);
        return new ResponseEntity<>(unit, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> deleteUnit(Integer unitId) {
        unitService.delete(unitId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
