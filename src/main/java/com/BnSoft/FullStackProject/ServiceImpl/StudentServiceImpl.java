package com.BnSoft.FullStackProject.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BnSoft.FullStackProject.Entitys.Student;
import com.BnSoft.FullStackProject.Exceptions.StudentAlreadyExist;
import com.BnSoft.FullStackProject.Exceptions.StudentNotFoundException;
import com.BnSoft.FullStackProject.repository.StudentRepository;
import com.BnSoft.FullStackProject.service.StudentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository repository;

	@Override
	public Student getStudentById(Integer id) {

		return repository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found for given " + id));
	}

	@Override
	public List<Student> getAllStudent() {
		return repository.findAll();
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		return repository.findById(id).map(st -> {
			st.setDeportment(student.getDeportment());
			st.setFirstName(student.getFirstName());
			st.setLastName(student.getLastName());
			st.setEmail(student.getEmail());
			return repository.save(st);
		}).orElseThrow(() -> new StudentNotFoundException(" Sorry student could not been found"));

	}

	private boolean studentExcit(String email) {

		return repository.findByEmail(email).isPresent();
	}

	@Override
	public Student createStudent(Student student) {
		if (studentExcit(student.getEmail())) {
			throw new StudentAlreadyExist("student alredy excit for given Email " + student.getEmail());
		}

		return repository.save(student);
	}

	@Override
	public void deleteStudentById(Integer id) {
		if (!repository.existsById(id)) {
			new StudentNotFoundException(" Sorry student could not been found for thr id" + id);
		}
		repository.deleteById(id);
	}

}
