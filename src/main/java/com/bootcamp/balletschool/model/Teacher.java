package com.bootcamp.balletschool.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;
    private int age;
    private int yearExp;

    @OneToMany(mappedBy = "teacher")
    private List<ClassType> ClassTypes;
}
