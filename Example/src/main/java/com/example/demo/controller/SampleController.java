package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Repository.SampleRepository;
import com.example.Service.SampleService;
import com.example.model.SampleEntity;

@RestController
public class SampleController {
 
    @Autowired
  private  SampleRepository sampleRepository;
    
    	
    @RequestMapping(value="/homepage")
    public String home()
    {
    	
    	return "index";
    	
    }
    @RequestMapping("/getemp")
    public ResponseEntity<Optional<SampleEntity>> getemp(@RequestParam Long Id) {
    	Optional<SampleEntity> employee = sampleRepository.findById(Id);
        return ResponseEntity.ok().body(employee);
    }
 
    @GetMapping(path = "/employees",produces = "application/json")
        public List<SampleEntity> sample() {
        return sampleRepository.findAll();
    }
    @PostMapping("/employees")
    public SampleEntity createEmployee(@Valid @RequestBody SampleEntity employee) {
        return sampleRepository.save(employee);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<SampleEntity>> getEmployeeById(@PathVariable(value = "id") Long Id)
        {
        Optional<SampleEntity> employee = sampleRepository.findById(Id);
        return ResponseEntity.ok().body(employee);
    }
    
    @PutMapping("/employees/{id}")
	public ResponseEntity<SampleEntity> update(
			@PathVariable(value="id") Long Id, @RequestBody SampleEntity todo){
		
				SampleEntity todoUpdated = sampleRepository.save(todo);
		
		return new ResponseEntity<SampleEntity>(todo, HttpStatus.OK);
	}

    @DeleteMapping("/employees{id}")
	public ResponseEntity<SampleEntity> deleteTodo(
			@PathVariable(value="id") Long Id){
		
    	Object employee = sampleRepository.findById(Id);
    System.out.print(employee.toString());
    	sampleRepository.deleteById(Id);
		
     	return (ResponseEntity<SampleEntity>) employee;
		//return ResponseEntity.notFound().build();
	}
    
    
    
}