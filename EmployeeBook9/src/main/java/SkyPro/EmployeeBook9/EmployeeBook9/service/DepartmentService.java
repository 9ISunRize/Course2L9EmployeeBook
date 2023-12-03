package SkyPro.EmployeeBook9.EmployeeBook9.service;

import SkyPro.EmployeeBook9.EmployeeBook9.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findMinSalaryByDepartment(int numberOfDepartment);

    Employee findMaxSalaryByDepartment(int numberOfDepartment);

    int getTotalSalaryCostByDepartment(int department);

    Map<Integer, List<Employee>> getAllEmployeesByDepartment(int department);

    Map<Integer, List<Employee>> getAllEmployees();
}
