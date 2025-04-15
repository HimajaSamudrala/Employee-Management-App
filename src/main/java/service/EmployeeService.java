package service;

import domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    String saveEmployee(Employee employee);
    String deleteEmployee(Long id);
    Optional<Employee> getEmployeeById(Long id);
}