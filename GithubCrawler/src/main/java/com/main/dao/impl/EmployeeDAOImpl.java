package com.main.dao.impl;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.main.dao.EmployeeDAO;
import com.main.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private final String hashReference= "Employee";

    @Resource(name="redisTemplate")          // 'redisTemplate' is defined as a Bean in AppConfig.java
    private HashOperations<String, Integer, Employee> hashOperations;
    
    @Autowired
    RedisTemplate<String, Employee> redisTemplate;
	@Override
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		hashOperations.put(hashReference, emp.getEmpId(), emp);
		//redisTemplate.opsForHash().put(hashReference, emp.getEmpId(), emp);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		// TODO Auto-generated method stub
		return hashOperations.get(hashReference, id);
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Integer, Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAllEmployees(Map<Integer, Employee> map) {
		// TODO Auto-generated method stub

	}

}
