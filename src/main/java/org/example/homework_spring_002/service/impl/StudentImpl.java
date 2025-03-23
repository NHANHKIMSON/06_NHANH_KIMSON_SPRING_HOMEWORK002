package org.example.homework_spring_002.service.impl;

import org.example.homework_spring_002.model.Dto.entity.Student;
import org.example.homework_spring_002.model.Dto.request.StudentRequest;
import org.example.homework_spring_002.repository.CourseRepository;
import org.example.homework_spring_002.repository.StudentRepository;
import org.example.homework_spring_002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentImpl implements StudentService {

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;
    public StudentImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents(int page, int size) {
        return studentRepository.getAllStudents(page, size);
    }

    @Override
    public List<Student> getStudentsById(Integer studentId) {
        return studentRepository.getStudentsById(studentId);
    }

    @Override
    public List<Student> deleteStudentById(Integer id) {
        return studentRepository.deleteStudentById(id);
    }

    @Override
    public List<Student> addNewStudent(StudentRequest studentRequest) {
        Student student  = studentRepository.addNewStudent(studentRequest);
        for (Integer courseId : studentRequest.getCourses()) {
            courseRepository.insertStudentCourse(student.getStudentId(), courseId);
        }
        return getStudentsById(student.getStudentId());
    }

    @Override
    public List<Student> updateStudentCourse(Integer studentId, StudentRequest studentRequest) {
        Student student = studentRepository.updateStudent(studentId, studentRequest);
        courseRepository.deleteStudentCourse(studentId);
        for (Integer courseId : studentRequest.getCourses()) {
            courseRepository.insertStudentCourse(studentId, courseId);
        }
        return getStudentsById(student.getStudentId());
    }
}
