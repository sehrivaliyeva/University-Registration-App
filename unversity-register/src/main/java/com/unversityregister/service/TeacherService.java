package com.unversityregister.service;

import com.unversityregister.demo.Profession;
import com.unversityregister.demo.Teacher;
import com.unversityregister.dto.TeacherRequest;
import com.unversityregister.dto.TeacherResponse;
import com.unversityregister.repository.ProfessionRepository;
import com.unversityregister.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final ModelMapper modelMapper;
    private final ProfessionRepository professionRepository;

    public List<TeacherResponse> findAll() {
        List<Teacher> teacherList = teacherRepository.findAll();
        List<TeacherResponse> teacherResponses = teacherList.stream().map(item ->
                modelMapper.map(item, TeacherResponse.class)).collect(Collectors.toList());
        return teacherResponses;
    }

    public Optional<TeacherResponse> findById(Integer id) {
        var teacher = teacherRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(teacher, TeacherResponse.class));

    }

    public TeacherResponse create(TeacherRequest teacherRequest) {
        var teacher = modelMapper.map(teacherRequest, Teacher.class);
        var newTeacher = teacherRepository.save(teacher);
        return modelMapper.map(newTeacher, TeacherResponse.class);

    }

    public TeacherResponse update(Integer id, TeacherRequest teacherRequest) {
        var teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("no information in database"));
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        if (teacherRequest.getProfessionId() != null) {
            Profession profession = professionRepository.findById(teacherRequest.getProfessionId())
                    .orElseThrow(() -> new RuntimeException("No information in database"));
            teacher.setProfession(profession);
        }


        var newTeacher = teacherRepository.save(teacher);
        return modelMapper.map(newTeacher, TeacherResponse.class);
    }

    public void delete(Integer id) {
        teacherRepository.deleteById(id);
    }

}
