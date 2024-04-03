package com.unversityregister.controller;

import com.unversityregister.dto.ProfessionRequest;
import com.unversityregister.dto.ProfessionResponse;
import com.unversityregister.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profession")
@RequiredArgsConstructor
public class ProfessionController {
    private final ProfessionService professionService;

    @PostMapping
    public ProfessionResponse create(@RequestBody ProfessionRequest professionRequest) {
        return professionService.create(professionRequest);
    }
}
