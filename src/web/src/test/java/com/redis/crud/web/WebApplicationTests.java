package com.redis.crud.web;

import static org.assertj.core.api.Assertions.assertThat;

import com.redis.crud.web.dto.StudentDto;
import com.redis.crud.web.service.spec.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebApplicationTests {

    @Mock
    StudentService studentService;


    @Test
    void contextLoads() {
        var s = StudentDto.builder().id(555L).age(33).name("Slava").build();
        Mockito.when(studentService.getStudentById(Mockito.any()))
            .thenReturn(s);

        assertThat(studentService.getStudentById(555L)).isSameAs(s);
    }

}
