package org.example.first.service.business.implementation;

import org.example.first.service.api.model.UnitDto;
import org.example.first.service.business.contrat.UnitService;
import org.example.first.service.client.entity.Unit;
import org.example.first.service.client.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    UnitRepository unitRepository;

    public List<UnitDto> findAll() {
        List<Unit> units = unitRepository.findAll();
        return units.stream().map(unit -> new UnitDto(unit.getId(), unit.getName())).collect(Collectors.toList());
    }

    public UnitDto findById(Integer unitId) {
        Optional<Unit> unit = unitRepository.findById(unitId);
        return unit.map(value -> new UnitDto(value.getId(), value.getName())).orElse(null);
    }

    public UnitDto create(UnitDto unitDto) {
        // sheck if unit name is already in the database
        if (unitRepository.findByName(unitDto.getName()).isPresent()) {
            return null;
        }
        Unit unit = new Unit();
        unit.setName(unitDto.getName());
        Unit responseUnit = unitRepository.save(unit);
        return new UnitDto(responseUnit.getId(), responseUnit.getName());
    }

    public UnitDto update(Integer unitId, UnitDto unitDto) {
        Optional<Unit> unit = unitRepository.findById(unitId);
        if (unit.isPresent()) {
            Unit unitToUpdate = unit.get();
            unitToUpdate.setName(unitDto.getName());
            Unit responseUnit =  unitRepository.save(unitToUpdate);
            return new UnitDto(responseUnit.getId(), responseUnit.getName());
        }
        return null;

    }

    public void delete(Integer unitId) {
        unitRepository.deleteById(unitId);
    }
}
