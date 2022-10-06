package de.tei.codeexample.cleancode.handler;


import de.tei.codeexample.cleancode.entity.EmployeeEntity;
import de.tei.codeexample.cleancode.model.DayOfType;
import de.tei.codeexample.cleancode.repository.EmployeeRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class EmployeeHandler {

    private final EmployeeRepository employeeRepository;

    public EmployeeHandler(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity get(Integer id) throws NoSuchElementException {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        return optionalEmployeeEntity.orElseThrow();
    }

    public List<EmployeeEntity> getAll() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return employeeRepository.insert(employeeEntity);
    }

    public EmployeeEntity update(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public void delete(EmployeeEntity employeeEntity) {
        employeeRepository.delete(employeeEntity);
    }

    public Integer getDayOfEntrance(String dayOfType, EmployeeEntity employeeEntity) {
        return switch (DayOfType.valueOf(dayOfType)) {
            case MONTH -> employeeEntity.getEntranceDate().getDayOfMonth();
            case WEEK -> employeeEntity.getEntranceDate().getDayOfWeek().getValue();
            case YEAR -> employeeEntity.getEntranceDate().getDayOfYear();
        };
    }
}
