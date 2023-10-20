package com.kubudirira.studentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kubudirira.studentcrud.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public String index(){
        return "index";
    }

 

    @GetMapping("/students")           
    public String getAllStudents(Model model){

        List<Student> studentList = service.getAllStudents();
        model.addAttribute("studentList", studentList);
        
        return "student";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id){        
        service.deleteStudent(id);
        return "redirect:/students";
    }


    
    @GetMapping("/student/edit/{id}")
    public String editStudent(@PathVariable("id") Integer id, Model  model){

        Student student =  service.getStudent(id);

        model.addAttribute("student", student);

        return "edit";
    }
    
    @PostMapping("/student/save")
    public String saveStudent(Student student){
        service.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/student/add")
    public String addStudent(Model model){

        model.addAttribute("student", new Student());
        return "add";

    }


    /*

    //READ - GET 
    @GetMapping("/students")  
    @ResponseBody     
    public List<Student> getAllStudents(Model model){

        List<Student> studentList = service.getAllStudents();
        model.addAttribute("studentList", studentList);
        
        return studentList;
    }    


    //CREATE - POST

    @GetMapping("/students/add")
    public ResponseEntity<Student> addStudent(){

        Student student = new Student();

		student.setEmail("Jane1@gmail.com");
		student.setFirst_name("Jane1");
		student.setLast_name("Doe1");
        service.saveStudent(student);  

        return new ResponseEntity<Student>(student,HttpStatus.CREATED);

    }

    //CREATE - POST
    @PostMapping("/student/save")
    public ResponseEntity<HttpStatus> saveStudent(@RequestBody Student student){
        service.saveStudent(student);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    //UPDATE - PUT
    @PutMapping("/students/update/{id}")
    public ResponseEntity<HttpStatus> updateStudent(@PathVariable Integer id, @RequestBody Student student){

        Student searchStudent = service.getStudent(id);

        searchStudent.setEmail(student.getEmail());
        searchStudent.setFirst_name(student.getFirst_name());
        searchStudent.setLast_name(student.getLast_name());

        service.saveStudent(searchStudent);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    //DELETE
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Integer id){

          service.deleteStudent(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    */   

    
}
