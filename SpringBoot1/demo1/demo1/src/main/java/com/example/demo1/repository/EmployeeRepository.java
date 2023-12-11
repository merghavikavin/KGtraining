package com.example.demo1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo1.entity.Employee;
 
import java.util.List;
 
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAll();
}
