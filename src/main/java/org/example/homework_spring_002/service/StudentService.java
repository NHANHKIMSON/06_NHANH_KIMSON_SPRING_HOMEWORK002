package org.example.homework_spring_002.service;

import org.example.homework_spring_002.model.Dto.entity.Student;
import org.example.homework_spring_002.model.Dto.request.StudentRequest;

import java.util.List;

public interface  StudentService {



    List<Student> getStudents(int page, int size);
    List<Student> getStudentsById(Integer id);
    List<Student> deleteStudentById(Integer id);
    List<Student> addNewStudent(StudentRequest studentRequest);
    List<Student> updateStudentCourse(Integer studentId, StudentRequest studentRequest);
}
