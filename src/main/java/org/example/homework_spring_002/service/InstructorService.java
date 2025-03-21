package org.example.homework_spring_002.service;

import org.example.homework_spring_002.model.Dto.entity.Instructor;
import org.example.homework_spring_002.model.Dto.request.InstructorRequest;

import java.util.List;


public interface InstructorService {
    List<Instructor> addInstructor(int limit, int offset);
    List<Instructor> addInstructor(InstructorRequest instructorRequest);
    List<Instructor> getInstructorById(Integer id);
    List<Instructor> updateInstructor(Integer id, InstructorRequest instructorRequest);
}
