package com.bootcamp.balletschool.repository;

import com.bootcamp.balletschool.model.ClassType;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface ClassTypeRepository extends JpaRepository<ClassType,Long> {
}
