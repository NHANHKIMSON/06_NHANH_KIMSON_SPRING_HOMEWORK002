package org.example.homework_spring_002.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.homework_spring_002.model.Dto.entity.Student;
import org.example.homework_spring_002.model.Dto.response.ApiInstructorResponse;
import org.example.homework_spring_002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    @Operation(summary = "Get all student")
    ResponseEntity<ApiInstructorResponse<List<Student>>> getAllStudents() {
        ApiInstructorResponse<List<Student>> apiInstructorResponse = ApiInstructorResponse.<List<Student>>builder()
                .message("Get all student has been successfully")
                .payload(studentService.getStudents())
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }

    @GetMapping("{student-id}")
    @Operation(summary = "Get student by id")
    ResponseEntity<ApiInstructorResponse<List<Student>>> getStudentsById(@PathVariable("student-id") Integer studentId) {
        ApiInstructorResponse<List<Student>> apiInstructorResponse = ApiInstructorResponse.<List<Student>>builder()
                .message("Get student By id ")
                .payload(studentService.getStudentsById(studentId))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }

    @DeleteMapping("{student-id}")
    @Operation(summary = "Delete student by id")
    ResponseEntity<ApiInstructorResponse<List<Student>>> deleteStudentById(@PathVariable("student-id") Integer studentId) {

        ApiInstructorResponse<List<Student>> apiInstructorResponse = ApiInstructorResponse.<List<Student>>builder()
                .message("Delete student by id successfully!")
                .payload(studentService.deleteStudentById(studentId))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }
}
