package com.learn.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.learn.springboot.crud.dto.Student;
import com.learn.springboot.crud.repository.StudentRepository;

@Controller
public class ControllerClass {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/")
	public String getHome()
	{
		return "main";
	}
	
	@GetMapping("/insert")
	public String getInsert()
	{
		return "insertstudent";
	}
	
	@GetMapping("/add-student")
	public String addStduent(Student student, ModelMap map)
	{
		studentRepository.save(student);
		map.put("success", "Added "+student.getName()+" details successfully");
		return fetchAllStudent(map);
	}
	
	@GetMapping("/fetchall")
	public String fetchAllStudent(ModelMap map)
	{
		List<Student> students = studentRepository.findAll();
		if (students.isEmpty())
		{
			map.put("failure", "No Student Records available");
		}
		else
		{
			map.put("students", students);
		}
		return "main";
	}
}
