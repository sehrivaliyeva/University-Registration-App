package com.unversityregister.service;

import com.unversityregister.demo.Student;
import com.unversityregister.dto.StudentRequest;
import com.unversityregister.dto.StudentResponse;
import com.unversityregister.dto.StudentUpdateRequest;
import com.unversityregister.mapper.StudentMapper;
import com.unversityregister.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper mapper;


    public StudentResponse create(StudentRequest request) {
        var student = mapper.map(request, Student.class);
        var studentNew = studentRepository.save(student);
        var response = mapper.map(studentNew, StudentResponse.class);
        return response;
    }

    public List<StudentResponse> getAllStudent() {

        List<Student> studentList = studentRepository.findAll();
        List<StudentResponse> studentResponseList = studentList.stream().map(itm ->
                mapper.map(itm, StudentResponse.class)
        ).collect(Collectors.toList());
        return studentResponseList;
    }

    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    public StudentResponse update(StudentUpdateRequest request, Integer id) {
        var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("no information in database"));
        student = mapper.map(request, Student.class);
        student.setId(id);
        var studentNew = studentRepository.save(student);
        var studentResponse = mapper.map(studentNew, StudentResponse.class);
        return studentResponse;
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public List<StudentResponse> findByGroupNo(String groupNo) {

        var student = studentRepository.findByGroupNo(groupNo);
        var studentNew = mapper.map(student, StudentResponse.class);
        return (List<StudentResponse>) studentNew;
    }
}
