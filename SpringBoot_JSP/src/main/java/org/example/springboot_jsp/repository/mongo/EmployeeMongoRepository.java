package org.example.springboot_jsp.repository.mongo;

import org.example.springboot_jsp.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeMongoRepository extends MongoRepository<Employee, Integer> {
}
