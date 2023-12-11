package com.example.login.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.login.entity.Employee;

@Service
public class EmployeeService {
    public Employee createEmployee(String empId, String fname, String sname) {
        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setFirstName(fname);
        emp.setSecondName(sname);
        return emp;
    }

    public void deleteEmployee(String empId) {
    }

    public List<Employee> getAllEmployees() {
        return null;
    }

    public Employee getEmployeeById(int id) {
        return null;
    }
}
