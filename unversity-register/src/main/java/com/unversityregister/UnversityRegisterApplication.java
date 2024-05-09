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
public class UnversityRegisterApplication {


    public static void main(String[] args) {
        SpringApplication.run(UnversityRegisterApplication.class, args);

    }


}
