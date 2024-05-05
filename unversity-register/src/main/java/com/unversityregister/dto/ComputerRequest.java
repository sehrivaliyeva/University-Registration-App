package com.unversityregister.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ComputerRequest {
    private String name;
    private String code;
}
