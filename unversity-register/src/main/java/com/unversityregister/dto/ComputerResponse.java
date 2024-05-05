package com.unversityregister.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ComputerResponse {
    private Integer id;
    private String name;
    private String code;
}
