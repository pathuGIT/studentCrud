package com.wak.studentCrud.service;

import com.wak.studentCrud.model.Lecturer;
import com.wak.studentCrud.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LecturerService {
    @Autowired
    private LecturerRepository lecturerRepository;

    public Lecturer AddLecturer(Lecturer lecturer){
        return lecturerRepository.save(lecturer);
    }

    public List<Lecturer> ViewLecturer(){
        List<Lecturer> lecturerExist = lecturerRepository.findAll();
        ArrayList<Lecturer> lecturers = new ArrayList<>();

            for(Lecturer lecturer : lecturerExist){
                Lecturer lec = new Lecturer();
                lec.setId(lecturer.getId());
                lec.setName(lecturer.getName());
                lec.setMail(lecturer.getMail());
                lecturers.add(lec);
            }
        return lecturers;
    }
}
