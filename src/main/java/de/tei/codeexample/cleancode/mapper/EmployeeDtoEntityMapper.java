package de.tei.codeexample.cleancode.mapper;

import de.tei.codeexample.cleancode.dto.Employee;
import de.tei.codeexample.cleancode.entity.EmployeeEntity;

public class EmployeeDtoEntityMapper {

    public Employee mapToDto(EmployeeEntity entity) {
        Employee dto = new Employee();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setRole(entity.getRole());
        dto.setDepartment(entity.getDepartment());
        dto.setEntranceDate(entity.getEntranceDate());
        return dto;
    }

    public EmployeeEntity mapToEntity(Employee dto) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setRole(dto.getRole());
        entity.setDepartment(dto.getDepartment());
        entity.setEntranceDate(dto.getEntranceDate());
        return entity;
    }
}
