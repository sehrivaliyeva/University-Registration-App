package com.unversityregister.mapper;

import com.unversityregister.demo.Student;
import com.unversityregister.dto.StudentRequest;
import com.unversityregister.dto.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "birthDay", source = "birthDay")
    @Mapping(target = "profession", source = "profession")
    @Mapping(target = "groupNo", source = "groupNo")
    @Mapping(target = "studentCode", source = "studentCode")
    Student mapRequestToStudent(StudentRequest request);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "groupNo", source = "groupNo")
    @Mapping(target = "studentCode", source = "studentCode")
    StudentResponse mapStudentToResponse(Student student);
}
