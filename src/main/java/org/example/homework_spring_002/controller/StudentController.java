package org.example.homework_spring_002.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.example.homework_spring_002.model.Dto.entity.Student;
import org.example.homework_spring_002.model.Dto.request.StudentRequest;
import org.example.homework_spring_002.model.Dto.response.ApiResponse;
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
    ResponseEntity<ApiResponse<List<Student>>> getAllStudents(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        ApiResponse<List<Student>> apiResponse = ApiResponse.<List<Student>>builder()
                .message("Get all student has been successfully")
                .payload(studentService.getStudents(page, size))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("{student-id}")
    @Operation(summary = "Get student by id")
    ResponseEntity<ApiResponse<List<Student>>> getStudentsById(@PathVariable("student-id") Integer studentId) {
        ApiResponse<List<Student>> apiResponse = ApiResponse.<List<Student>>builder()
                .message("Get student By id ")
                .payload(studentService.getStudentsById(studentId))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("{student-id}")
    @Operation(summary = "Delete student by id")
    ResponseEntity<ApiResponse<List<Student>>> deleteStudentById(
            @PathVariable("student-id") Integer studentId
    ) {

        ApiResponse<List<Student>> apiResponse = ApiResponse.<List<Student>>builder()
                .message("Delete student by id successfully!")
                .payload(studentService.deleteStudentById(studentId))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    @Operation(summary = "Create new Student")
    ResponseEntity<ApiResponse<List<Student>>> addNewStudent(@RequestBody StudentRequest studentRequest) {
        ApiResponse<List<Student>> apiResponse = ApiResponse.<List<Student>>builder()
                .message("Created new student successfully")
                .payload(studentService.addNewStudent(studentRequest))
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("{student-id}")
    @Operation(summary = "Update student")
    ResponseEntity<ApiResponse<List<Student>>> updateStudent(@PathVariable("student-id") Integer studentId, @RequestBody StudentRequest studentRequest) {
        ApiResponse<List<Student>> apiResponse = ApiResponse.<List<Student>>builder()
                .message("Update student successfully")
                .payload(studentService.updateStudentCourse(studentId, studentRequest))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiResponse);
    }
}


