package com.unversityregister.config;

import com.unversityregister.demo.Student;
import com.unversityregister.dto.StudentRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {


    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
}


