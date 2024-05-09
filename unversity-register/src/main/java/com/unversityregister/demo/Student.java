package com.unversityregister.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Data
@Entity
@Table(name = "students")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String name;
    private String lastName;
    private String birthDay;
    private String groupNo;
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
