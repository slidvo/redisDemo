package com.example.redis.crud.repositories.impl;

import com.example.redis.crud.model.Employee;
import com.example.redis.crud.repositories.EmployeeDao;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private String hashRef = "Employee";

    @Resource(name = "redisTemplateEmployee")
    private HashOperations<String, Integer, Employee> hashOperations;

    @Override
    public void save(Employee employee) {
        hashOperations.putIfAbsent(hashRef, employee.getId(), employee);
    }

    @Override
    public Employee getById(Integer id) {
        return hashOperations.get(hashRef, id);
    }

    @Override
    public void saveAll(Map<Integer, Employee> map) {
        hashOperations.putAll(hashRef,map);
    }

    @Override
    public Map<Integer, Employee> getAll() {
        return hashOperations.entries(hashRef);
    }
}
