package com.unversityregister.controller;

import com.unversityregister.dto.ProfessionRequest;
import com.unversityregister.dto.ProfessionResponse;
import com.unversityregister.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/profession")
@RequiredArgsConstructor
public class ProfessionController {
    private final ProfessionService professionService;

    @GetMapping
    public List<ProfessionResponse> findAll() {
        return professionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProfessionResponse> findById(@PathVariable Integer id) {
        return professionService.findById(id);
    }

    @PostMapping
    public ProfessionResponse create(@RequestBody ProfessionRequest professionRequest) {
        return professionService.create(professionRequest);
    }

    @PutMapping("/{id}")
    public ProfessionResponse update(@PathVariable Integer id, @RequestBody ProfessionRequest updateRequest) {
        return professionService.update(id,updateRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        professionService.delete(id);
    }
}
