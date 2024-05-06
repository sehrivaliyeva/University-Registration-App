package com.unversityregister.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "students")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "first_name")
    private String name;
    private String lastName;
    private String birthDay;
    private String groupNo;
    @Column(unique = true)
    private String studentCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profession_id")
    private Profession profession;

    @OneToOne
    @JoinColumn(name = "computer_id")
    private Computer computer;

    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers;
}
