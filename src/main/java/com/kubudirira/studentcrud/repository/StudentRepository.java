package com.kubudirira.studentcrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.kubudirira.studentcrud.controller.Student;

public interface StudentRepository  extends CrudRepository<Student, Integer>{
    
}
