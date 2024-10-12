package com.wak.studentCrud.service;

import com.wak.studentCrud.model.Student;
import com.wak.studentCrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //Create new student
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    //Update student
    public Student updateStudent(Long id, Student student){
        Optional<Student> exeistStdnt = studentRepository.findById(id);
        Student updtStdnt = exeistStdnt.get();
        updtStdnt.setName(student.getName());
        updtStdnt.setAge(student.getAge());
        updtStdnt.setEmail(student.getEmail());
        return  studentRepository.save(updtStdnt);
    }

    //Get
    public List<Student> getStudent(){
        List<Student> searchStudent = studentRepository.findAll();
        ArrayList<Student> studentList = new ArrayList<>();

        for(Student student : searchStudent){
            Student studentRecord = new Student();
            studentRecord.setId(student.getId());
            studentRecord.setName(student.getName());
            studentRecord.setAge(student.getAge());
            studentRecord.setEmail(student.getEmail());
            studentList.add(studentRecord);
        }

        return studentList;
    }

    //DELETE
    public ResponseEntity<String> deleteStudent(Long id){
        Optional<Student> exitStd = studentRepository.findById(id);

        if(exitStd.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        }else{
            return ResponseEntity.ok("No Student id found..");
        }
    }
}
