package com.BnSoft.FullStackProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BnSoft.FullStackProject.Entitys.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Optional<Student> findByEmail(String email);

}
