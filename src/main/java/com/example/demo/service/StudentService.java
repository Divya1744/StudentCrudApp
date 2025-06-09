package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;
	public List<Student> getAll() {
		
		return studentRepo.findAll();
	}
	public String addStudents(Student student) {
		
		studentRepo.save(student);
		return "added succesfully";
	}
	public Student getByRno(int rno) {
		
		
		return studentRepo.findById(rno).orElse(new Student());
	}
	public String updateStudent(Student student) {
		
		studentRepo.save(student);
		return "update successful";
	}
	public String delByRno(int rno) {
		
		studentRepo.deleteById(rno);
		return "deletion successful";
	}
	public String deleteAll() {
		
		studentRepo.deleteAll();
		return "deleted all the students";
		
	}
	public List<Student> getByDept(String department) {
		
		return studentRepo.findByDept(department);
	}
	public List<Student> findByGenderAndDept(String gender, String dt) {
		return studentRepo.findByGenderAndDept(gender, dt);
		
	}
	
	

}
