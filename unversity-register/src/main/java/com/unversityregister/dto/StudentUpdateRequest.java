package com.unversityregister.dto;

import lombok.Data;

@Data
public class StudentUpdateRequest {
    private String name;
    private String lastName;
    private String birthDay;
    private String profession;
    private String groupNo;
    private String studentCode;
    private Integer professionId;
    private Integer computerId;
}
