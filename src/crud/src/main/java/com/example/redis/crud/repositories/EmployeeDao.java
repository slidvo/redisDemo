package com.example.redis.crud.repositories;

import com.example.redis.crud.model.Employee;
import java.util.Map;

public interface EmployeeDao {
    void save(Employee employee);

    Employee getById(Integer id);

    void saveAll(Map<Integer,Employee> map);

    Map<Integer,Employee> getAll();
}
