package SkyPro.EmployeeBook9.EmployeeBook9.controller;


import SkyPro.EmployeeBook9.EmployeeBook9.model.Employee;
import SkyPro.EmployeeBook9.EmployeeBook9.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam String surname, @RequestParam int salary,
                                @RequestParam int department) {
        return employeeService.addEmployee(name, surname, salary, department);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String name, @RequestParam String surname) {
        return employeeService.removeEmployee(name, surname);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String name, @RequestParam String surname) {
        return employeeService.findEmployee(name, surname);
    }
/*
 @GetMapping("/departments")
 public String printDepartmentsAndNames() {
     return employeeService.printAllDepartmentsAndNames();
 }*/

    @GetMapping()
    public Collection showEmployee() {
        return employeeService.getEmployeeMap();
    }
}

