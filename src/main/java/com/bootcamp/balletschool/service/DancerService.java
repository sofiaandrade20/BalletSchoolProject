package com.bootcamp.balletschool.service;

import com.bootcamp.balletschool.controller.request.CreateDancerRequest;
import com.bootcamp.balletschool.exception.DancerNotFound;
import com.bootcamp.balletschool.model.Dancer;
import com.bootcamp.balletschool.repository.DancerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DancerService {
    private final DancerRepository dancerRepository;

    public DancerService(DancerRepository dancerRepository) {
        this.dancerRepository = dancerRepository;
    }

    //Get all dancers
    public List<Dancer> findAll() {
        return dancerRepository.findAll();
    }

    //Get dancer by id
    public Dancer findById(Long id) {
        return dancerRepository.findById(id)
                .orElseThrow(() -> new DancerNotFound("Dancer does not exists."));
    }

    //Save dancer
    public Dancer addDancer(CreateDancerRequest dancer) {
        Dancer newDancer = Dancer
                .builder()
                .name(dancer.getName())
                .age(dancer.getAge())
                .grade(dancer.getGrade())
                .build();
        dancerRepository.save(newDancer);
        return newDancer;
    }

    //Update dancer
    public Dancer updateAge(Long id, int age) {
        Dancer dancer = dancerRepository.findById(id)
                .orElseThrow(() -> new DancerNotFound("Dancer does not exists."));
        dancer.setAge(age);
        return dancerRepository.save(dancer);
    }
}
