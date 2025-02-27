package com.employeelist.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeelist.springboot.model.Employee;

// now we can get database operations for Employee entity by using JPA repository
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,  Long>{

}
