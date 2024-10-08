package org.example.springboot_jsp.service;

import org.example.springboot_jsp.model.Employee;
import org.example.springboot_jsp.repository.elastic.EmployeeElasticRepository;
import org.example.springboot_jsp.repository.mongo.EmployeeMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMongoRepository employeeMongoRepository;

    @Autowired
    EmployeeElasticRepository employeeElasticRepository;

//    Inserting the Employee Details in Both MongoDB & Elasticsearch
    public void saveEmployee(Employee employee) {
        employeeMongoRepository.save(employee);
        employeeElasticRepository.save(employee);
    }

//    Getting Employee Details using ID
    public Optional<Employee> findEmployeeById(int id) {
        return employeeMongoRepository.findById(id);
    }

//    Getting all the Employee Details from both MongoDB & Elasticsearch
    public List<Employee> findAllEmployees() {
        Set<Employee> allEmployeesSet = new HashSet<>();
        allEmployeesSet.addAll(employeeMongoRepository.findAll());
        employeeElasticRepository.findAll().forEach(allEmployeesSet::add);
        return allEmployeesSet.stream().collect(Collectors.toList());
    }

    //  Update the Employee in MongoDB & Elasticsearch
    public void updateEmployee(int id, String name, String department) {
        // Update in MongoDB
        Optional<Employee> mongoEmployee = employeeMongoRepository.findById(id);
        if (mongoEmployee.isPresent()) {
            Employee employee = mongoEmployee.get();
            employee.setName(name);
            employee.setDepartment(department);
            employeeMongoRepository.save(employee);
        }
        // Update in Elasticsearch
        Optional<Employee> elasticEmployee = employeeElasticRepository.findById(id);
        if (elasticEmployee.isPresent()) {
            Employee employee = elasticEmployee.get();
            employee.setName(name);
            employee.setDepartment(department);
            employeeElasticRepository.save(employee);
        }
    }

//    Delete the Employee Details using ID
    public String deleteEmployeeById(int id) {
        Optional<Employee> op=employeeMongoRepository.findById(id);
        if(op.isPresent()) {
            employeeMongoRepository.deleteById(id);
            employeeElasticRepository.deleteById(id);
            return "Data Deleted Successfully!!";
        }else{
            return "No Data found!!";
        }
    }

//    Delete All the Employee Details in both MongoDB & Elasticsearch
    public String deleteAllEmployeesData() {
        List<Employee> mongoEmployees=employeeMongoRepository.findAll();
        List<Employee> elasticEmployee = new ArrayList<>();
        employeeElasticRepository.findAll().forEach(elasticEmployee::add);
        if(mongoEmployees.isEmpty() && elasticEmployee.isEmpty()) {
            return "No Data Found!!";
        }else{
            employeeMongoRepository.deleteAll();
            employeeElasticRepository.deleteAll();
            return "Data Deleted Successfully!!";
        }
    }
}