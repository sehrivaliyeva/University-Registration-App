package com.unversityregister.controller;

import com.unversityregister.demo.Computer;
import com.unversityregister.dto.ComputerRequest;
import com.unversityregister.dto.ComputerResponse;
import com.unversityregister.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/computer")
@RequiredArgsConstructor
public class ComputerController {
    private final ComputerService computerService;

    @GetMapping
    public List<ComputerResponse> findAll() {
        return computerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ComputerResponse> findById(@PathVariable Integer id) {
        return computerService.findById(id);
    }

    @PostMapping
    public ComputerResponse create(@RequestBody ComputerRequest computerRequest) {
        return computerService.create(computerRequest);
    }

    @PatchMapping("/{name}")
    public Optional<Computer> updateByName(@RequestParam String name){
        return Optional.ofNullable(computerService.updateByName(name));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        computerService.delete(id);
    }
}
