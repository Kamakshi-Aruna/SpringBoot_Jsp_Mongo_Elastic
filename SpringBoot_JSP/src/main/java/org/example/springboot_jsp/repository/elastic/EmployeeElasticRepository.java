package org.example.springboot_jsp.repository.elastic;

import org.example.springboot_jsp.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeElasticRepository extends ElasticsearchRepository<Employee, Integer> {
}
