package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController 
{
	@GetMapping(path = "/hello")
	public String helloWorld(){

		return "student controller working";
		
	}
}