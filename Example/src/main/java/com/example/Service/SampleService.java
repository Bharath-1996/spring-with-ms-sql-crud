package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.example.Repository.SampleRepository;
import com.example.model.SampleEntity;

@Service
@EnableJpaRepositories("com.example.Repository")
public class SampleService {
 
    @Autowired
   private SampleRepository sampleRepo;
 
        public List<SampleEntity> getAll() {
        return sampleRepo.getAll();
    }
}
