package de.tei.codeexample.cleancode.repository;

import de.tei.codeexample.cleancode.entity.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, Integer> {
}
