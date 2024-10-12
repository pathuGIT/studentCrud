package com.wak.studentCrud.controller;

import com.wak.studentCrud.model.Student;
import com.wak.studentCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired; // Import for @Autowired
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")  // Allows requests from any origin
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired  // Add this annotation
    private StudentService studentService;

    // CREATE
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);  // Return the saved student wrapped in ResponseEntity
    }

    //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student ){
        Student updateStudent = studentService.updateStudent(id,student);
        return ResponseEntity.ok(updateStudent);
    }

    //READ
    @GetMapping("/get")
    public ResponseEntity<List<Student>> getStudent(){
        List<Student> getStudent = studentService.getStudent();
        return ResponseEntity.ok(getStudent);
    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
