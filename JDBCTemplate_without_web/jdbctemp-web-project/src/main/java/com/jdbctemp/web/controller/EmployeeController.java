package com.jdbctemp.web.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
import com.jdbctemp.web.model.Employee;
import com.jdbctemp.web.model.EmployeeDao;
 
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    {System.out.println("............ EmployeeController non static block .............");}
    @Autowired
    private EmployeeDao employeeDao;
 
    @RequestMapping("/")
    public String showPage() {
{System.out.println("................. EmployeeController showPage ....................");}
       
        int status = employeeDao.saveEmployee(new Employee(102, "Amit", 35000));
       // System.out.println(status);
       
 
        List<Employee> allEmployees = employeeDao.allEmployees();
 
        allEmployees.stream().forEach(System.out::println);
        return "home";
    }
}