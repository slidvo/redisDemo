package com.example.redis.crud;

import com.example.redis.crud.repositories.impl.EmployeeDaoImpl;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RedisOperationsRunner implements CommandLineRunner {
    @Autowired
    EmployeeDaoImpl employeeDao;

    @Override
    public void run(String... args) {
//        employeeDao.save(new Employee(501, "Employee0", 215.0));
//        employeeDao.saveAll(Map.of(
//            502,new Employee(502, "Employee0", 502.0),
//            503,new Employee(503, "Employee0", 503.0),
//            504,new Employee(504, "Employee0", 504.0),
//            505,new Employee(505, "Employee0", 505.0)
//        ));

        Logger.getGlobal().info(employeeDao.getById(500).toString());
        Logger.getGlobal().info(employeeDao.getById(502).toString());

        employeeDao.getAll().forEach((integer, employee) -> {
            System.out.println(integer +": "+ employee);
        });

    }
}
