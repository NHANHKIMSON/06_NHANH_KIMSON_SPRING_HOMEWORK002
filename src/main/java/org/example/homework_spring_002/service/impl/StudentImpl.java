package org.example.homework_spring_002.service.impl;

import org.example.homework_spring_002.model.Dto.entity.Student;
import org.example.homework_spring_002.repository.StudentRepository;
import org.example.homework_spring_002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentImpl implements StudentService {

    private final StudentRepository studentRepository;
    public StudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public List<Student> getStudentsById(Integer studentId) {
        return studentRepository.getStudentsById(studentId);
    }

    @Override
    public List<Student> deleteStudentById(Integer id) {
        return studentRepository.deleteStudentById(id);
    }
}
