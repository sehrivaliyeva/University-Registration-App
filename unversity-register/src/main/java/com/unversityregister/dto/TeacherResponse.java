package com.unversityregister.dto;

import lombok.Data;

@Data
public class TeacherResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer professionId;
}
