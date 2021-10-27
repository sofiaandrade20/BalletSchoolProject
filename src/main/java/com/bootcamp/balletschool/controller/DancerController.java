package com.bootcamp.balletschool.controller;

import com.bootcamp.balletschool.controller.request.CreateDancerRequest;
import com.bootcamp.balletschool.controller.request.UpdateDancerRequest;
import com.bootcamp.balletschool.controller.request.UpdateTeacherRequest;
import com.bootcamp.balletschool.exception.DancerNotFound;
import com.bootcamp.balletschool.model.Dancer;
import com.bootcamp.balletschool.model.Teacher;
import com.bootcamp.balletschool.service.DancerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Validated
public class DancerController {
    public final DancerService dancerService;

    public DancerController(DancerService dancerService) {
        this.dancerService = dancerService;
    }

    //Get all dancers
    @GetMapping("/get-dancers")
    public List<Dancer> getDancers(){
        return dancerService.findAll();
    }

    //Get dancer by id
    @GetMapping("/get-dancersById/{id}")
    public Dancer getDancerById(@PathVariable(value = "id") Long id) {
        return dancerService.findById(id);
    }

    //Create dancer
    @PostMapping("/post-dancer")
    public Dancer addDancer(@RequestBody CreateDancerRequest newDancer) {
        return dancerService.addDancer(newDancer);
    }

    //Update dancer
    @PutMapping("/put-teacher/{id}/age")
    public ResponseEntity updateDancer(@PathVariable Long id, @RequestBody UpdateDancerRequest request) {
        final Dancer updatedDancer = dancerService.updateAge(id, request.getAge());
        return ResponseEntity.created(URI.create("/dancer/" + id + "/age")).body("Updated Age");
    }
}
