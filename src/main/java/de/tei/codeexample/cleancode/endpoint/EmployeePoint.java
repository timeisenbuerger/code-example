package de.tei.codeexample.cleancode.endpoint;

import de.tei.codeexample.cleancode.dto.Employee;
import de.tei.codeexample.cleancode.handler.EmployeeHandler;
import de.tei.codeexample.cleancode.mapper.EmployeeDtoEntityMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeePoint {

    private final EmployeeHandler employeeHandler;
    private final EmployeeDtoEntityMapper employeeDtoEntityMapper;

    public EmployeePoint(EmployeeHandler employeeHandler, EmployeeDtoEntityMapper employeeDtoEntityMapper) {
        this.employeeHandler = employeeHandler;
        this.employeeDtoEntityMapper = employeeDtoEntityMapper;
    }

    @GetMapping(value = "/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeDtoEntityMapper.mapToDto(employeeHandler.get(id)));
    }

    @GetMapping(value = "/employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeHandler.getAll().stream().map(employeeDtoEntityMapper::mapToDto).collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeDtoEntityMapper.mapToDto(employeeHandler.save(employeeDtoEntityMapper.mapToEntity(employee))));
    }

    @PutMapping(value = "/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeDtoEntityMapper.mapToDto(employeeHandler.update(employeeDtoEntityMapper.mapToEntity(employee))));
    }

    @DeleteMapping(value = "/employee")
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeHandler.delete(employeeDtoEntityMapper.mapToEntity(employee));
    }

    @GetMapping(value = "employee/dayOfEntrance/{format}")
    public ResponseEntity<Integer> getDayOfEntrance(@PathVariable String format, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeHandler.getDayOfEntrance(format, employeeDtoEntityMapper.mapToEntity(employee)));
    }
}
