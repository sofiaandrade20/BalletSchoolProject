package com.bootcamp.balletschool.model;

import lombok.*;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "dancer")
public class Dancer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;
    private int age;
    private int grade;

    @ManyToMany(mappedBy = "class_dancer")
    private List<ClassType> classTypes;
}
