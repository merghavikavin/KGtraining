package com.example.demo1.service;


 
import com.example.demo1.entity.Employee;
 
import java.util.List;
 
public interface EmployeeService {
 
    List<Employee> getAllEmployees();
 
    Employee createEmployee(Employee employee);
 
    Employee getEmployeeById(int id);
 
    Employee updateEmployee(int id, Employee updatedEmployee);
 
    boolean deleteEmployee(int id);

}

