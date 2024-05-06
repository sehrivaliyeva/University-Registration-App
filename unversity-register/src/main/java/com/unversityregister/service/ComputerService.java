package com.unversityregister.service;

import com.unversityregister.demo.Computer;
import com.unversityregister.dto.ComputerRequest;
import com.unversityregister.dto.ComputerResponse;
import com.unversityregister.repository.ComputerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComputerService {
    private final ComputerRepository computerRepository;
    private final ModelMapper modelMapper;

    public List<ComputerResponse> findAll() {
        List<Computer> computers = computerRepository.findAll();
        List<ComputerResponse> computerResponseList = computers.stream().map(item ->
                modelMapper.map(item, ComputerResponse.class)).collect(Collectors.toList());
        return computerResponseList;

    }

    public Optional<ComputerResponse> findById(Integer id) {
        var computer = computerRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(computer, ComputerResponse.class));
        //null exceptionun qarshisini almaq ucun ici bos bir optional yaradir bu metod
    }


    public ComputerResponse create(ComputerRequest computerRequest) {
        var computer = modelMapper.map(computerRequest, Computer.class);
        var newComputer = computerRepository.save(computer);
        return modelMapper.map(newComputer, ComputerResponse.class);
    }

    public Computer updateByName(String name) {
        ComputerResponse computerResponse = computerRepository.findByName(name);
        var newComputer = modelMapper.map(computerResponse, Computer.class);
        return computerRepository.save(newComputer);

    }

    public void delete(Integer id) {
        computerRepository.deleteById(id);
    }
}
