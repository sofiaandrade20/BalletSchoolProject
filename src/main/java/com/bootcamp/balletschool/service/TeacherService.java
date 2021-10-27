package com.bootcamp.balletschool.service;

import com.bootcamp.balletschool.controller.request.CreateTeacherRequest;
import com.bootcamp.balletschool.exception.TeacherNotFound;
import com.bootcamp.balletschool.model.Teacher;
import com.bootcamp.balletschool.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    //Get all teachers
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    //Get teacher by id
    public Teacher findById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFound("Teacher does not exists."));
    }

    //Save teacher
    public Teacher addTeacher(CreateTeacherRequest teacher) {
        Teacher newTeacher = Teacher
                .builder()
                .name(teacher.getName())
                .age(teacher.getAge())
                .yearExp(teacher.getYearExp())
                .build();
        teacherRepository.save(newTeacher);
        return newTeacher;
    }

    //Update teacher
    public Teacher updateExperience(Long id, int yearsExp) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new TeacherNotFound("Teacher does not exists."));
        teacher.setYearExp(yearsExp);
        return teacherRepository.save(teacher);
    }
}

