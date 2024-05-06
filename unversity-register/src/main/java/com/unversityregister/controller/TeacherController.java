package com.unversityregister.controller;

import com.unversityregister.dto.TeacherRequest;
import com.unversityregister.dto.TeacherResponse;
import com.unversityregister.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public List<TeacherResponse> findAll() {
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TeacherResponse> findById(@PathVariable Integer id) {
        return teacherService.findById(id);
    }

    @PostMapping
    public TeacherResponse create(@RequestBody TeacherRequest teacherRequest) {
        return teacherService.create(teacherRequest);
    }

    @PutMapping("/{id}")
    public TeacherResponse update(@PathVariable Integer id, @RequestBody TeacherRequest teacherRequest) {
        return teacherService.update(id, teacherRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        teacherService.delete(id);
    }
}
