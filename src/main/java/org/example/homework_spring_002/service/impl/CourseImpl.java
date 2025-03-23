package org.example.homework_spring_002.service.impl;

import org.example.homework_spring_002.model.Dto.entity.Course;
import org.example.homework_spring_002.model.Dto.request.CourseRequest;
import org.example.homework_spring_002.repository.CourseRepository;
import org.example.homework_spring_002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public List<Course> getAllCourse(int page, int size) {

        System.out.println(page);
        System.out.println(size);
        System.out.println(courseRepository.getAllCourse(page, size));

        return courseRepository.getAllCourse(page, size);
    }

    @Override
    public List<Course> getCourseById(Integer id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public List<Course> deleteCourse(Integer id) {
        return courseRepository.deleteCourse(id);
    }

    @Override
    public List<Course> addCourse(CourseRequest courseRequest) {
        return courseRepository.addCourse(courseRequest);
    }

    @Override
    public List<Course> updateCourse(Integer id, CourseRequest courseRequest) {
        return courseRepository.updateCourse(id, courseRequest);
    }

}
