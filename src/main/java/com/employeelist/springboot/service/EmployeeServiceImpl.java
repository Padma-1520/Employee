package com.employeelist.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeelist.springboot.model.Employee;
import com.employeelist.springboot.repository.EmployeeRepository;

//this class will implements EmployeeSevice interface
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired // here we are injecting employee Repository using @Autowired annotation
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
            return employeeRepository.findAll(); // findall method basically return list of employees
       
    }
    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional < Employee > optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

}
