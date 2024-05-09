package com.unversityregister.dto;

import com.unversityregister.demo.Computer;
import com.unversityregister.demo.Profession;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class StudentResponse {
    private Integer id;
    private String name;
    private String lastName;
    private String groupNo;
    private String studentCode;
    private String birthDay;
    private Integer professionId;
    private Integer computerId;
}
