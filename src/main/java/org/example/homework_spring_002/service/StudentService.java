package org.example.homework_spring_002.service;

import org.example.homework_spring_002.model.Dto.entity.Student;

import java.util.List;

public interface  StudentService {



    List<Student> getStudents();
    List<Student> getStudentsById(Integer id);
    List<Student> deleteStudentById(Integer id);
}
