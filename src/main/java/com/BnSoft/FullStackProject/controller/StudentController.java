package com.BnSoft.FullStackProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BnSoft.FullStackProject.Entitys.Student;
import com.BnSoft.FullStackProject.ServiceImpl.StudentServiceImpl;

import lombok.RequiredArgsConstructor;
@CrossOrigin("http://localhost:300")
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

	private final StudentServiceImpl studentServiceImpl;

	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudent() {
		return new ResponseEntity<>(studentServiceImpl.getAllStudent(), HttpStatus.FOUND);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getById(@PathVariable Integer id) {
		return new ResponseEntity<Student>(studentServiceImpl.getStudentById(id), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentServiceImpl.createStudent(student), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Integer id) {
		return new ResponseEntity<Student>(studentServiceImpl.updateStudent(student, id), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> delete(@PathVariable Integer id) {
		studentServiceImpl.deleteStudentById(id);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);

	}

}
