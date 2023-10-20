package com.kubudirira.studentcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kubudirira.studentcrud.controller.Student;
import com.kubudirira.studentcrud.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    //save

    public void saveStudent(Student student){        
        repo.save(student);
    }


    //get 1 Student
    public Student getStudent(Integer id){
        
        Optional<Student> student = repo.findById(id);

        if(student.isPresent()){
            return student.get();
        }


        return new Student(); //throw exception


    }


    //get all students
    public List<Student> getAllStudents(){

        //List<Student> studentList = (List<Student>) repo.findAll();


        return (List<Student>) repo.findAll();
    }


    //delete

    public void deleteStudent(Integer id){

        //Student student = repo.findById(id).get(); 

        repo.delete(repo.findById(id).get());
    }
    
}
