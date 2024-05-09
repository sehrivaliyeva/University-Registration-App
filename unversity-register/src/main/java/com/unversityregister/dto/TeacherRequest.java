package com.unversityregister.dto;

import com.unversityregister.demo.Profession;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class TeacherRequest {
    private String firstName;
    private String lastName;
    private Integer professionId;

}
