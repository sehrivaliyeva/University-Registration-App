package com.unversityregister.service;

import com.unversityregister.demo.Profession;
import com.unversityregister.dto.ProfessionRequest;
import com.unversityregister.dto.ProfessionResponse;
import com.unversityregister.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessionService {
    private final ProfessionRepository professionRepository;
    private final ModelMapper modelMapper;

    public List<ProfessionResponse> findAll() {
        List<Profession> professionList = professionRepository.findAll();
        List<ProfessionResponse> professionResponses = professionList.stream().map(item ->
                modelMapper.map(item, ProfessionResponse.class)).collect(Collectors.toList());
        return professionResponses;
    }

    public Optional<ProfessionResponse> findById(Integer id) {
        var profession = professionRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(profession, ProfessionResponse.class));

    }

    public ProfessionResponse create(ProfessionRequest professionRequest) {
        var profession = modelMapper.map(professionRequest, Profession.class);
        var newProfession = professionRepository.save(profession);
        return modelMapper.map(newProfession, ProfessionResponse.class);

    }

    public ProfessionResponse update(Integer id, ProfessionRequest updateRequest) {
        var profession = professionRepository.findById(id).orElseThrow(() -> new RuntimeException("no information in database"));
        profession.setName(updateRequest.getName());
        profession = professionRepository.save(profession);
        return modelMapper.map(profession, ProfessionResponse.class);

    }

    public void delete(Integer id) {
        professionRepository.deleteById(id);
    }
}
