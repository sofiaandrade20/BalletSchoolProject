package com.bootcamp.balletschool.controller;

import com.bootcamp.balletschool.controller.request.CreateTeacherRequest;
import com.bootcamp.balletschool.controller.request.UpdateTeacherRequest;
import com.bootcamp.balletschool.model.Teacher;
import com.bootcamp.balletschool.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@Validated
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //Get all teachers
    @GetMapping("/get-teachers")
    public List<Teacher> getTeachers(){
        return teacherService.findAll();
    }

    //Get teacher by id
    @GetMapping("/get-teachersById/{id}")
    public Teacher getTeacherById(@PathVariable(value = "id") Long id) {
        return teacherService.findById(id);
    }

    //Create teacher
    @PostMapping("/post-teacher")
    public Teacher newTeacher(@RequestBody CreateTeacherRequest newTeacher) {
        return teacherService.addTeacher(newTeacher);
    }

    //Update teacher
    @PutMapping("/put-teacher/{id}/years")
    public ResponseEntity updateExperience(@PathVariable Long id, @RequestBody UpdateTeacherRequest request) {
        final Teacher updatedExperience = teacherService.updateExperience(id, request.getYearExp());
        return ResponseEntity.created(URI.create("/teacher/" + id + "/experience")).body("Updated Experience");
    }
}

