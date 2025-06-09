package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>
{
	List<Student>findByDept(String department);
	
	@Query(nativeQuery=true, value = "select * from student where gender=:gen and dept=:dt")
	List<Student>findByGenderAndDept(@Param("gen")String gen,@Param("dt")String dt);
}

