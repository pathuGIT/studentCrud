package com.wak.studentCrud.controller;

import com.wak.studentCrud.model.Lecturer;
import com.wak.studentCrud.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/lecturer")
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @PostMapping("/add")
    public ResponseEntity<String> AddLecturer(@RequestBody Lecturer lecturer){
        lecturerService.AddLecturer(lecturer);
        return ResponseEntity.ok("Lecture Added.");
    }
    @GetMapping("/view")
    public ResponseEntity<List<Lecturer>> ViewLecturer(){
        List<Lecturer> getLect = lecturerService.ViewLecturer();
        return ResponseEntity.ok(getLect);
    }
}
