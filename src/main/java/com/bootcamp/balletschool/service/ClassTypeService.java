package com.bootcamp.balletschool.service;

import com.bootcamp.balletschool.controller.request.CreateClassTypeRequest;
import com.bootcamp.balletschool.exception.ClassTypeNotFound;
import com.bootcamp.balletschool.model.ClassType;
import com.bootcamp.balletschool.repository.ClassTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTypeService {
    private final ClassTypeRepository classTypeRepository;

    public ClassTypeService(ClassTypeRepository classTypeRepository) {
        this.classTypeRepository = classTypeRepository;
    }

    //Get all classes
    public List<ClassType> findAll() {
        return classTypeRepository.findAll();
    }

    //Get dancer by id
    public ClassType findById(Long id) {
        return classTypeRepository.findById(id)
                .orElseThrow(() -> new ClassTypeNotFound("Class does not exists."));
    }

    //Create class
    public ClassType addClassType(CreateClassTypeRequest classType) {
        ClassType newClassType = ClassType
                .builder()
                .name(classType.getName()).build();
        classTypeRepository.save(newClassType);
        return newClassType;
    }

    //Delete class
    public void deleteById(Long classTypeId) {
        classTypeRepository.deleteById(classTypeId);
    }
}
