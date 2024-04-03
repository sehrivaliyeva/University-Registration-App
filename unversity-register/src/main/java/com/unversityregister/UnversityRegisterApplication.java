package com.unversityregister;

import com.unversityregister.demo.Student;
import com.unversityregister.repository.StudentRepository;
import com.unversityregister.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor//proyekt ilk defe ise dusende studentler yaradir bazada(h2-de)
public class UnversityRegisterApplication implements ApplicationRunner {
    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(UnversityRegisterApplication.class, args);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
      /*  Student elcin = Student.builder()
                .name("elcin")
                .lastName("Orucaliyev")
                .birthDay("12.01.1992")
                .profession("IT")
                .groupNo("2RUDF")
                .studentCode("34DR")
                .build();

        Student ayaz = Student.builder()
                .name("ayaz")
                .lastName("Mammadov")
                .birthDay("12.08.1995")
                .profession("DB")
                .groupNo("01GDH")
                .studentCode("A5JD").build();
        studentRepository.saveAll(Arrays.asList(elcin, ayaz));*/

    }
}
