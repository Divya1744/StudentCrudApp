package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	@GetMapping("/students")
	public List<Student>getAll()
	{
		return studentService.getAll();
	}
	
	@PostMapping("students")
	public ResponseEntity<String> addStudents( @RequestBody Student student)
	{
		studentService.addStudents(student);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("students/{rno}")
	public ResponseEntity<Student> getByRno(@PathVariable int rno)
	{
		Student student = studentService.getByRno(rno);
		if(student == null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@PutMapping("students")
	public String updateStudent(@RequestBody Student student)
	{
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("students/{rno}")
	public String delByRno(@PathVariable int rno)
	{
		return studentService.delByRno(rno);
	}
	
	@DeleteMapping("students/clear")
	public String deleteAll()
	{
		return studentService.deleteAll();
	}
	
	@GetMapping("students/dept/{dept}")
	public List<Student> getByDept(@PathVariable("dept")String department)
	{
		return studentService.getByDept(department);
	}
	
	@GetMapping("students/filter")
	public List<Student> findByGenderAndDept(@RequestParam("gender")String gen,@RequestParam("dept")String dt)
	{
		return studentService.findByGenderAndDept(gen,dt);
	}
}
