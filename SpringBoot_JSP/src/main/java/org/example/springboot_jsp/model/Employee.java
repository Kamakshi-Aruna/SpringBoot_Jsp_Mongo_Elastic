package org.example.springboot_jsp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "employees")
@org.springframework.data.mongodb.core.mapping.Document(collection = "employees")
public class Employee {
    @Id
    private Integer id;
    private String name;
    private String department;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id != null && id.equals(employee.id); // Check based on unique id
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0; // Use id for hash calculation
    }
}
