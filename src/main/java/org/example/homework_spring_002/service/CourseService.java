package org.example.homework_spring_002.service;

import org.example.homework_spring_002.model.Dto.entity.Course;
import org.example.homework_spring_002.model.Dto.request.CourseRequest;

import java.util.List;
public interface CourseService {
    List<Course> getAllCourse(int page, int size);
    List<Course> getCourseById(Integer id);
    List<Course> deleteCourse(Integer id);
    List<Course> addCourse(CourseRequest courseRequest);
    List<Course> updateCourse(Integer id, CourseRequest courseRequest);
}
