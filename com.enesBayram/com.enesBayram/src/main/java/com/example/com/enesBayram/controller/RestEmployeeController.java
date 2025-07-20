package com.example.com.enesBayram.controller;
import com.example.com.enesBayram.model.Employee;
import com.example.com.enesBayram.model.UpdateEmployeeRequest;
import com.example.com.enesBayram.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/getById/{id}")
    public Employee getEmployeeById(@PathVariable int id) throws Exception {
        return employeeService.getEmployee(id);
    }


    @GetMapping("/getByParam")
    public List<Employee> getEmployeeWithParam(@RequestParam(name = "firstName")String firstName,
                                               @RequestParam(name = "lastName")String lastName) throws Exception {
        System.out.println("First Name: " + firstName + ", Last Name: " + lastName);
        return employeeService.getEmployeeWithParam(firstName, lastName);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/update-employee/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody UpdateEmployeeRequest request){
        return employeeService.updateEmployee(id, request);
    }
}
