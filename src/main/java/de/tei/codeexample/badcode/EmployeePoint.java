package de.tei.codeexample.badcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeePoint {

    @Autowired
    private EmployeeRepository er;

    @GetMapping(value = "/get/{id}")
    public EmployeeEntity getEmployee(@PathVariable int id) {
        return er.findById(id).get();
    }

    @GetMapping(value = "/getAll")
    public List<EmployeeEntity> getEmployee() {
        return er.findAll();
    }

    @PostMapping(value = "/save")
    public void createEmployee(@RequestBody EmployeeEntity employeeEntity) {
        er.insert(employeeEntity);
    }

    @PutMapping(value = "/update")
    public void updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        er.save(employeeEntity);
    }

    @DeleteMapping(value = "/delete")
    public void getEmployee(@RequestBody EmployeeEntity employeeEntity) {
        er.delete(employeeEntity);
    }

    @GetMapping(value = "/getDayOfEntrance/{format}")
    public Integer getDayOfEntrance(@PathVariable String format, @RequestBody EmployeeEntity employeeEntity) {
        switch (format) {
            case "MONTH" -> {
                return employeeEntity.getEntranceDate().getDayOfMonth();
            }
            case "WEEK" -> {
                return employeeEntity.getEntranceDate().getDayOfWeek().getValue();
            }
            case "YEAR" -> {
                return employeeEntity.getEntranceDate().getDayOfYear();
            }
            default -> {
                return -1;
            }
        }
    }
}
