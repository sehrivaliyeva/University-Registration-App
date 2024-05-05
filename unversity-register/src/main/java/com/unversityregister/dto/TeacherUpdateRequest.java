package com.unversityregister.dto;

import lombok.Data;

@Data
public class TeacherUpdateRequest {
    private String firstName;
    private String lastName;
    private Integer professionId;
}
