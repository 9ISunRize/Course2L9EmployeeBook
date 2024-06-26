package SkyPro.EmployeeBook9.EmployeeBook9.service;


import SkyPro.EmployeeBook9.EmployeeBook9.expectoin.EmployeeAlreadyAddedException;
import SkyPro.EmployeeBook9.EmployeeBook9.expectoin.EmployeeNotFoundException;
import SkyPro.EmployeeBook9.EmployeeBook9.expectoin.InvalidateInputException;
import SkyPro.EmployeeBook9.EmployeeBook9.expectoin.MaximumEmployeesException;
import SkyPro.EmployeeBook9.EmployeeBook9.model.Employee;
import org.antlr.v4.runtime.misc.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.annotation.Contract;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;
    private static final int MAX_EMPLOYEES = 10;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }


    @Override
    public Collection<Employee> getEmployeeMap() {
        return this.employeeMap.values();
    }


    @Override
    public Employee addEmployee(String name, String surname, int salary, int department) {
        Employee employee = new Employee(name, surname, salary, department);
        validateInput(name, surname);
        if (!employeeMap.containsKey(employee.getName() + employee.getSurname())) {
            employeeMap.put(employee.getName() + employee.getSurname(), employee);
            return employee;
        } else if (employeeMap.size() > MAX_EMPLOYEES) {
            throw new MaximumEmployeesException("Максимальное количество сотрудников");
        }
        throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
    }

    @Override
    public Employee removeEmployee(String name, String surname) {
        validateInput(name, surname);

        if (employeeMap.containsKey(name + surname)) {
            employeeMap.remove(name + surname);
            return new Employee(name, surname);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String name, String surname) {
        validateInput(name, surname);
        if (!employeeMap.containsKey(name + surname)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return new Employee(name, surname);
    }

    private String getKey(String name, String surname) {
        return name + " " + surname;
    }

    private void validateInput(String name, String surname) {
        if (!(isAlpha(name) && isAlpha(surname))) {
            throw new InvalidateInputException();
        }

    }
}

