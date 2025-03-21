package org.example.homework_spring_002.service.impl;

import org.example.homework_spring_002.model.Dto.entity.Instructor;
import org.example.homework_spring_002.model.Dto.request.InstructorRequest;
import org.example.homework_spring_002.repository.InstructorRepository;
import org.example.homework_spring_002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstructorImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    public InstructorImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    @Override
    public List<Instructor> addInstructor(int page, int size) {
        int offset = (page - 1) * size;
        return instructorRepository.getAllInstructor(size, offset);
    }
    @Override
    public List<Instructor> addInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.addInstructor(instructorRequest);
    }
    public List<Instructor> getInstructorById(Integer id){
        return instructorRepository.getInstructorById(id);
    }
    public List<Instructor> updateInstructor(Integer id, InstructorRequest instructorRequest) {
        return instructorRepository.updateInstructor(id, instructorRequest);
    }
}
