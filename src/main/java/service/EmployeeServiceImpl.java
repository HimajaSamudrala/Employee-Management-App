package service;

import constants.AppConstants;
import domain.Employee;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String saveEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findByFirstNameAndLastName(employee.getFirstName(), employee.getLastName());
        if (employeeOptional.isEmpty()) {
            employeeRepository.save(employee);
            return AppConstants.EMPLOYEE_SAVED_SUCCESSFULLY;
        } else {
            return AppConstants.EMPLOYEE_ALREADY_EXISTS;
        }
    }

    @Override
    public String deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return AppConstants.EMPLOYEE_DELETED_SUCCESSFULLY;
        } else {
            return AppConstants.EMPLOYEE_NOT_FOUND;
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}