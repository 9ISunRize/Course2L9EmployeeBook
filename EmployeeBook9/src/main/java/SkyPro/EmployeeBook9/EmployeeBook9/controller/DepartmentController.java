package SkyPro.EmployeeBook9.EmployeeBook9.controller;

import SkyPro.EmployeeBook9.EmployeeBook9.service.DepartmentService;
import SkyPro.EmployeeBook9.EmployeeBook9.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;


    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam int departmentID) {
        return departmentService.findMinSalaryByDepartment(departmentID);
    }

    @GetMapping(path = "/max-salary")
    public Employee EmployeeMaxSalary(@RequestParam int departmentID){
        return departmentService.findMaxSalaryByDepartment(departmentID);
    }

    @GetMapping(path = "/sum-salary")
    public int sumSalaryByDepartment(@RequestParam int departmentID) {
        return departmentService.getTotalSalaryCostByDepartment(departmentID);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment(@RequestParam int departmentID) {
        return departmentService.getAllEmployeesByDepartment(departmentID);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return departmentService.getAllEmployees();
    }


}

