package com.spring.multifield.search.predicate.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class StudentDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    private String firstName;

    private String lastName;

    private Integer rollNo;

    private String grade;

    private String parentName;

    private String section;

}
