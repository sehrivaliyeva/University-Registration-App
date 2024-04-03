package com.unversityregister.service;

import com.unversityregister.demo.Profession;
import com.unversityregister.dto.ProfessionRequest;
import com.unversityregister.dto.ProfessionResponse;
import com.unversityregister.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessionService {
    private final ProfessionRepository professionRepository;
    private final ModelMapper modelMapper;

    public ProfessionResponse create(ProfessionRequest professionRequest) {
        var student = modelMapper.map(professionRequest, Profession.class);
        var newStudent = professionRepository.save(student);
        var studentResponse = modelMapper.map(newStudent, ProfessionResponse.class);
        return studentResponse;

    }




}
