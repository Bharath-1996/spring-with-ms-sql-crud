package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.model.SampleEntity;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Long> {
 
    @Query("FROM SampleEntity")
    public List<SampleEntity> getAll();
}