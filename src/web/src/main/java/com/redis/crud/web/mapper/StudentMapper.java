package com.redis.crud.web.mapper;

import com.redis.crud.web.dto.StudentDto;
import com.redis.crud.web.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);

    Student fromDto(StudentDto studentDto);
}
