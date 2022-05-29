package com.redis.crud.web.service.spec;

import com.redis.crud.web.dto.StudentDto;
import com.redis.crud.web.model.Student;
import java.util.Map;

public interface StudentService {
    void save(StudentDto studentDto);

    Map<Long,StudentDto> getAll();

    StudentDto getStudentById(Long id);


}
