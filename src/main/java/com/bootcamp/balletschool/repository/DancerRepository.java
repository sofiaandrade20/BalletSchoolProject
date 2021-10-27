package com.bootcamp.balletschool.repository;

import com.bootcamp.balletschool.model.Dancer;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface DancerRepository extends JpaRepository<Dancer,Long> {
}
