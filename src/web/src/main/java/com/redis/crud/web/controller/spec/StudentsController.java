package com.redis.crud.web.controller.spec;

import com.redis.crud.web.dto.StudentDto;
import com.redis.crud.web.model.Student;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface StudentsController {
    ResponseEntity<StudentDto> getStudentById(Long id);

    Map<Long, StudentDto> getAllStudents();

    boolean saveStudent(StudentDto studentDto);
}
