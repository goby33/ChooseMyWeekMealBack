package org.example.first.service.business.implementation;

import org.example.first.service.api.model.UnitDto;
import org.example.first.service.client.entity.Unit;
import org.example.first.service.client.repository.UnitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UnitServiceImplTest {

    @Mock
    private UnitRepository unitRepositoryMock;

    @InjectMocks
    private UnitServiceImpl unitServiceMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllSuccess() {
        // Given
        Unit unit1 = new Unit();
        unit1.setName("Unit1");
        Unit unit2 = new Unit();
        unit2.setName("Unit2");
        List<Unit> listUnit1 = new ArrayList<>();
        listUnit1.add(unit1);
        listUnit1.add(unit2);

        when(unitRepositoryMock.findAll()).thenReturn(listUnit1);

        // When
        List<UnitDto> unitDtos = unitServiceMock.findAll();

        // Then
        assertEquals(2, unitDtos.size());
        assertEquals("Unit1", unitDtos.get(0).getName());
        assertEquals("Unit2", unitDtos.get(1).getName());
        verify(unitRepositoryMock, times(1)).findAll();
    }

    @Test
    void testFindByIdSuccess() {
        // Given
        Unit unit = new Unit();
        unit.setName("Unit1");

        when(unitRepositoryMock.findById(1)).thenReturn(Optional.of(unit));

        // When
        UnitDto unitDto = unitServiceMock.findById(1);

        // Then
        assertNotNull(unitDto);
        assertEquals("Unit1", unitDto.getName());
        verify(unitRepositoryMock, times(1)).findById(1);
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        when(unitRepositoryMock.findById(1)).thenReturn(Optional.empty());

        // When
        UnitDto unitDto = unitServiceMock.findById(1);

        // Then
        assertNull(unitDto);
        verify(unitRepositoryMock, times(1)).findById(1);
    }

    @Test
    void testCreateSuccess() {
        // Given
        UnitDto unitDto = new UnitDto(0,"Unit1");
        Unit unit = new Unit();
        unit.setName("Unit1");

        when(unitRepositoryMock.save(any(Unit.class))).thenReturn(unit);

        // When
        UnitDto unitDtoResult = unitServiceMock.create(unitDto);

        // Then
        assertNotNull(unitDtoResult);
        assertEquals("Unit1", unitDtoResult.getName());
        verify(unitRepositoryMock, times(1)).save(any(Unit.class));
    }

    @Test
    void testUpdateSuccess() {
        // Given
        UnitDto unitDto = new UnitDto(0,"Unit1");
        Unit unit = new Unit();
        unit.setName("OldName");

        when(unitRepositoryMock.findById(1)).thenReturn(Optional.of(unit));
        when(unitRepositoryMock.save(any(Unit.class))).thenReturn(unit);

        // When
        UnitDto unitDtoResult = unitServiceMock.update(1, unitDto);

        // Then
        assertNotNull(unitDtoResult);
        assertEquals("Unit1", unitDtoResult.getName());
        verify(unitRepositoryMock, times(1)).findById(1);
        verify(unitRepositoryMock, times(1)).save(any(Unit.class));
    }

    @Test
    void testUpdateNotFound() {
        // Given
        when(unitRepositoryMock.findById(1)).thenReturn(Optional.empty());

        UnitDto unitDto = new UnitDto(0,"Unit1");

        // When
        UnitDto unitDtoResult = unitServiceMock.update(1, unitDto);

        // Then
        assertNull(unitDtoResult);
        verify(unitRepositoryMock, times(1)).findById(1);
        verify(unitRepositoryMock, times(0)).save(any(Unit.class));
    }

    @Test
    void testDeleteSuccess() {
        // Given
        doNothing().when(unitRepositoryMock).deleteById(1);

        // When
        unitServiceMock.delete(1);

        // Then
        verify(unitRepositoryMock, times(1)).deleteById(1);
    }
}
