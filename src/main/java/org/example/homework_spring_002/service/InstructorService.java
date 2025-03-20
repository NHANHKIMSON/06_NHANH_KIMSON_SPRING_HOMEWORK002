package org.example.homework_spring_002.service;

import org.example.homework_spring_002.model.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InstructorService {
    List<Instructor> getAllInstructor();
}
