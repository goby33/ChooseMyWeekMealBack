package org.example.first.service.business.contrat;

import org.example.first.service.api.model.UnitDto;

import java.util.List;

public interface UnitService {
    public List<UnitDto> findAll();

    public UnitDto findById(Integer unitId);

    public UnitDto create(UnitDto unitDto);

    public UnitDto update(Integer unitId, UnitDto unitDto);

    public void delete(Integer unitId);

}
