package org.example.first.service.business.contrat;

import org.example.first.service.api.model.UnitDto;

import java.util.List;

public interface UnitService {
    List<UnitDto> findAll();

    UnitDto findById(Integer unitId);

    UnitDto create(UnitDto unitDto);

    UnitDto update(Integer unitId, UnitDto unitDto);

    void delete(Integer unitId);

}
