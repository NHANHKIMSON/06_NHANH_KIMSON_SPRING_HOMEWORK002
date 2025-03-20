package org.example.homework_spring_002.controller;


import org.example.homework_spring_002.model.Instructor;
import org.example.homework_spring_002.service.InstructorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping
    public List<Instructor> getAllInstructor (){
        return instructorService.getAllInstructor();
    }
}
