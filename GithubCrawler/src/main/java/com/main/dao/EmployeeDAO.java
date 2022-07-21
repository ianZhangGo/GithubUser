package com.main.dao;

import java.util.Map;

import com.main.entity.Employee;

public interface EmployeeDAO {
	void saveEmployee(Employee emp);
    Employee getOneEmployee(Integer id);
    void updateEmployee(Employee emp);
    Map<Integer, Employee> getAllEmployees();
    void deleteEmployee(Integer id);
    void saveAllEmployees(Map<Integer, Employee> map);

}
