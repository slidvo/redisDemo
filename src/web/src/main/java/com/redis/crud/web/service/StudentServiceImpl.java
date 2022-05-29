package com.redis.crud.web.service;

import com.redis.crud.web.dto.StudentDto;
import com.redis.crud.web.mapper.StudentMapper;
import com.redis.crud.web.model.Student;
import com.redis.crud.web.service.spec.StudentService;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    public static Logger logger = Logger.getLogger(StudentServiceImpl.class.getName());

    private String hashRef = "Student";

    @Resource(name = "redisTemplate")
    private HashOperations<String, Long, Student> hashOperations;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void save(@NonNull StudentDto studentDto) {
        var result = hashOperations
            .putIfAbsent(
                hashRef,
                studentDto.getId(),
                studentMapper.fromDto(studentDto)
            );
        logger.log(
            Level.INFO,
            "Student with id {0}, status of saving in redis {1} ",
            new Object[]{studentDto.getId(), result}
        );
    }

    @Override
    public Map<Long, StudentDto> getAll() {
        logger.log(Level.INFO,"Get all Student entries from redis data base");
        return hashOperations
            .entries(hashRef)
            .entrySet()
            .stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey, v -> studentMapper.toDto(v.getValue())
            ));
    }

    @Override
    public StudentDto getStudentById(@NonNull Long id) {
        return studentMapper.toDto(hashOperations.get(hashRef, id));
    }
}
