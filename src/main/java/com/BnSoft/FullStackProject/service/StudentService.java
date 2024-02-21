package com.BnSoft.FullStackProject.service;

import java.util.List;

import com.BnSoft.FullStackProject.Entitys.Student;

public interface StudentService {

	public Student getStudentById(Integer id);

	public List<Student> getAllStudent();

	public Student updateStudent(Student student, Integer id);

	public Student createStudent(Student student);

	public void deleteStudentById(Integer id);

}
