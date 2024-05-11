package com.unversityregister.service;

import com.unversityregister.demo.Computer;
import com.unversityregister.demo.Profession;
import com.unversityregister.demo.Student;
import com.unversityregister.dto.StudentRequest;
import com.unversityregister.dto.StudentResponse;
import com.unversityregister.repository.ComputerRepository;
import com.unversityregister.repository.ProfessionRepository;
import com.unversityregister.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper mapper;
    private final ProfessionRepository professionRepository;
    private final ComputerRepository computerRepository;

    public StudentResponse create(StudentRequest request) {
        Student student = mapper.map(request, Student.class);
        if (request.getProfession() != null) {
            Profession profession = professionRepository.findById(request.getProfession())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid professionId"));
            student.setProfession(profession);
        }
        if (request.getComputer() != null) {
            Computer computer = computerRepository.findById(request.getComputer())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid computerId"));
            student.setComputer(computer);
        }
        Student savedStudent = studentRepository.save(student);
        return mapper.map(savedStudent, StudentResponse.class);
    }

    public List<StudentResponse> getAll() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentResponse> studentResponseList = studentList.stream().map(itm ->
                mapper.map(itm, StudentResponse.class)
        ).collect(Collectors.toList());
        return studentResponseList;
    }

    public Optional<StudentResponse> findById(Integer id) {
        var student = studentRepository.findById(id);
        return Optional.ofNullable(mapper.map(student, StudentResponse.class));
    }

    public StudentResponse update(StudentRequest request, Integer id) {
        var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("no information in database"));
        //bu emeliyyat ona gore edilir ki student ve studentrequest siniflerindeki field adlari ferqli ola biler
        student = mapper.map(request, Student.class);
        student.setName(request.getName());
        student.setLastName(request.getLastName());
        student.setBirthDay(request.getBirthDay());
        student.setGroupNo(request.getGroupNo());
        student.setStudentCode(request.getStudentCode());
        if (request.getProfession() != null) {
            Profession profession = professionRepository.findById(request.getProfession())
                    .orElseThrow(() -> new RuntimeException("No information in database"));
            student.setProfession(profession);
        }
        if (request.getComputer() != null) {
            Computer computer = computerRepository.findById(request.getComputer())
                    .orElseThrow(() -> new RuntimeException("No information in database"));
            student.setComputer(computer);
        }

        var studentNew = studentRepository.save(student);
        var studentResponse = mapper.map(studentNew, StudentResponse.class);
        return studentResponse;
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public List<StudentResponse> findByGroupNo(String groupNo) {

        List<Student> students = studentRepository.findByGroupNo(groupNo);
        List<StudentResponse> studentResponse = students.stream().map(student -> mapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
        return studentResponse;
    }
}
