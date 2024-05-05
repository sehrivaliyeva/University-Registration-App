package com.unversityregister.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ComputerUpdateRequest {
    private String name;
    private String code;
}
