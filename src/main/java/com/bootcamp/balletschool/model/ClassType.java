package com.bootcamp.balletschool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "class")
public class ClassType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "class_dancer",
            joinColumns = @JoinColumn(name = "classTypeId"),
            inverseJoinColumns = @JoinColumn(name = "dancerId"))
    private List<Dancer> class_dancer;
}
