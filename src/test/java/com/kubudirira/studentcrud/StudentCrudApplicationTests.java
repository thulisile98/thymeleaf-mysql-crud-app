package com.kubudirira.studentcrud;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kubudirira.studentcrud.controller.Student;
import com.kubudirira.studentcrud.repository.StudentRepository;

import java.util.Optional;

@SpringBootTest
class StudentCrudApplicationTests {

	@Autowired
	private StudentRepository repo;

	@Test
	void CreateStudent(){
		Student student = new Student();

		student.setEmail("Jane@gmail.com");
		student.setFirst_name("Jane");
		student.setLast_name("Doe");

		Student savedStudent = repo.save(student);

		Assertions.assertThat(savedStudent).isNotNull();
		
	}

	@Test
	void readStudent(){
		Integer studentID = 1;
		Optional<Student> student = repo.findById(studentID);	
		Assertions.assertThat(student).isNotNull();
	}

	@Test
	void readAllStudent(){
		Iterable<Student> student = repo.findAll();
		Assertions.assertThat(student).hasSizeGreaterThan(0);

	}

	@Test
	void updateStudent(){
		Integer studentId = 1;
		Optional<Student> st = repo.findById(studentId);

		Student student = st.get();

		student.setEmail("katlego@tshimologong.joburg");

		repo.save(student);


		Optional<Student> updatedStudent = repo.findById(studentId);

		Assertions.assertThat(updatedStudent.get().getEmail()).isEqualTo("katlego@tshimologong.joburg");




	}


	@Test
	void deleteStudent(){
		Integer studentId = 1;
		repo.deleteById(studentId);
		Assertions.assertThat(repo.findById(studentId)).isNotPresent();
	}

}
