package com.bootcamp.balletschool.controller;

import com.bootcamp.balletschool.controller.request.CreateClassTypeRequest;
import com.bootcamp.balletschool.model.ClassType;
import com.bootcamp.balletschool.service.ClassTypeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class ClassTypeController {
    private final ClassTypeService classTypeService;
    public ClassTypeController(ClassTypeService classTypeService) {
        this.classTypeService = classTypeService;
    }

    //Get all classes
    @GetMapping("/get-classes")
    public List<ClassType> getClasses(){
        return classTypeService.findAll();
    }

    //Get class by id
    @GetMapping("/get-classesById/{id}")
    public ClassType getClassById(@PathVariable(value = "id") Long id) {
        return classTypeService.findById(id);
    }

    //Create class
    @PostMapping("/post-class")
    public ClassType addClassType(@RequestBody CreateClassTypeRequest newClassType) {
        return classTypeService.addClassType(newClassType);
    }

    //Delete class by id
    @DeleteMapping(value = "/delete-class/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        classTypeService.deleteById(id);
    }
}
