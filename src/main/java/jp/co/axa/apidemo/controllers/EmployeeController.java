package jp.co.axa.apidemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  public void setEmployeeService(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/employees")
  public List<Employee> getEmployees() {
    List<Employee> employees = employeeService.retrieveEmployees();
    return employees;
  }

  @GetMapping("/employees/{employeeId}")
  public ResponseEntity<Employee> getEmployee(
      @PathVariable(name = "employeeId") Long employeeId) {
    Optional<Employee> optEmployee = employeeService.getEmployee(employeeId);
    if (optEmployee.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Employee>(optEmployee.get(), HttpStatus.OK);
  }

  @PostMapping("/employees")
  public void saveEmployee(Employee employee) {
    employeeService.saveEmployee(employee);
    System.out.println("Employee Saved Successfully");
  }

  @DeleteMapping("/employees/{employeeId}")
  public ResponseEntity<String> deleteEmployee(
      @PathVariable(name = "employeeId") Long employeeId) {
    Optional<Employee> optEmployee = employeeService.getEmployee(employeeId);
    if (optEmployee.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    employeeService.deleteEmployee(employeeId);
    System.out.println("Employee Deleted Successfully");
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/employees/{employeeId}")
  public ResponseEntity<String> updateEmployee(
      @RequestBody Employee employee,
      @PathVariable(name = "employeeId") Long employeeId) {
    Optional<Employee> optEmployee = employeeService.getEmployee(employeeId);
    if (optEmployee.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    employeeService.updateEmployee(employee);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
