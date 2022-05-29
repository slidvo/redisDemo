package com.redis.crud.web.controller;

import com.redis.crud.web.controller.spec.StudentsController;
import com.redis.crud.web.dto.StudentDto;
import com.redis.crud.web.mapper.StudentMapper;
import com.redis.crud.web.model.Student;
import com.redis.crud.web.service.spec.StudentService;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentsControllerImpl  implements StudentsController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name = "id")  Long id) {
        Logger.getGlobal().log(Level.INFO,"GET STUDENT BY ID: {0}",id);
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/save")
    @Override
    public boolean saveStudent(@RequestBody StudentDto studentDto) {
        System.out.println(studentDto);
        try {
            studentService.save(studentDto);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @GetMapping("/all")
    public Map<Long,StudentDto> getAllStudents(){
        return studentService.getAll();
    }
}
