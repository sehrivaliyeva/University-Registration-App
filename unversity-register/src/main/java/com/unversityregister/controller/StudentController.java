package com.unversityregister.controller;

import com.unversityregister.demo.Student;
import com.unversityregister.dto.StudentRequest;
import com.unversityregister.dto.StudentResponse;
import com.unversityregister.dto.StudentUpdateRequest;
import com.unversityregister.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;


    @GetMapping
    public List<StudentResponse> getAll() {
        return studentService.getAllStudent();

    }

    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable("id") Integer id) {
        return studentService.findById(id);

    }

    @GetMapping("/{groupNo}")
    public List<StudentResponse> findByGroupNo(@PathVariable String groupNo) {
        return studentService.findByGroupNo(groupNo);
    }


    @PostMapping()
    public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest student) {
        return new ResponseEntity<>(studentService.create(student), HttpStatus.CREATED);

    }


    @PutMapping("/{id}")
    public StudentResponse update(@RequestBody StudentUpdateRequest request, @PathVariable Integer id) {
        return studentService.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }
}
