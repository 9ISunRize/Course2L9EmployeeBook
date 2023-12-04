package SkyPro.EmployeeBook9.EmployeeBook9.service;

import SkyPro.EmployeeBook9.EmployeeBook9.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    public Employee addEmployee(String name, String surname, int salary, int department);

    public Employee removeEmployee(String name, String surname);

    public Employee findEmployee(String name, String surname);

    public Collection<Employee> getEmployeeMap();

}
