package com.bootcamp.balletschool.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDancerRequest {
    private String name;
    private int age;
    private int grade;
}
