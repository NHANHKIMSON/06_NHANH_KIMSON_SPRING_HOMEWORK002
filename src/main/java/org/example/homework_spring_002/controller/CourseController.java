package org.example.homework_spring_002.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.example.homework_spring_002.model.Dto.entity.Course;
import org.example.homework_spring_002.model.Dto.request.CourseRequest;
import org.example.homework_spring_002.model.Dto.response.ApiInstructorResponse;
import org.example.homework_spring_002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @Operation(summary = "Get all course")
    @GetMapping
    ResponseEntity<ApiInstructorResponse<List<Course>>> getAllCourses(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        ApiInstructorResponse<List<Course>> apiInstructorResponse =  ApiInstructorResponse.<List<Course>>builder()
                .message("All courses have been successfully fetched.")
                .payload(courseService.getAllCourse(page, size))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }

    @GetMapping("{course-id}")
    ResponseEntity<ApiInstructorResponse<List<Course>>> getCourseById(@PathVariable("course-id") Integer id) {
        ApiInstructorResponse<List<Course>> apiInstructorResponse = ApiInstructorResponse.<List<Course>>builder()
                .message("The course has been successfully founded.")
                .payload(courseService.getCourseById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }

    @DeleteMapping("{course-id}")
    @Operation(summary = "Delete course by id")
    ResponseEntity<ApiInstructorResponse<List<Course>>> deleteCourseById(@PathVariable("course-id") Integer id) {
        ApiInstructorResponse<List<Course>> apiInstructorResponse = ApiInstructorResponse.<List<Course>>builder()
                .message("The course has been successfully removed.")
                .payload(courseService.deleteCourse(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(apiInstructorResponse);
    }

    @PostMapping
    @Operation(summary = "Add course")
    ResponseEntity<ApiInstructorResponse<List<Course>>> addCourse(@RequestBody CourseRequest courseRequest) {
        ApiInstructorResponse<List<Course>> apiInstructorResponse = ApiInstructorResponse.<List<Course>>builder()
                .message("The course has been successfully added.")
                .payload(courseService.addCourse(courseRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }

    @PutMapping("{course-id}")
    @Operation(summary = "Update course")
    ResponseEntity<ApiInstructorResponse<List<Course>>> updateCourse(@PathVariable("course-id") Integer id,  @RequestBody CourseRequest courseRequest) {
        ApiInstructorResponse<List<Course>> apiInstructorResponse = ApiInstructorResponse.<List<Course>>builder()
                .message("The course has been successfully updated.")
                .payload(courseService.updateCourse(id, courseRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }
}
