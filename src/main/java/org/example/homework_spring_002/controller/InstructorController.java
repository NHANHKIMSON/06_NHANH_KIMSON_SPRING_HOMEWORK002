package org.example.homework_spring_002.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.example.homework_spring_002.model.Dto.entity.Instructor;
import org.example.homework_spring_002.model.Dto.request.InstructorRequest;
import org.example.homework_spring_002.model.Dto.response.ApiInstructorResponse;
import org.example.homework_spring_002.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping
    @Operation(summary = "get All Instructor")
    ResponseEntity<ApiInstructorResponse<List<Instructor>>> getAllInstructor (
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        ApiInstructorResponse<List<Instructor>> apiInstructorResponse = ApiInstructorResponse.<List<Instructor>>builder()
                .message("All instructors have been successfully fetched.")
                .payload(instructorService.getAllInstructor(page, size))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }

    @PostMapping
    @Operation(summary = "Add instructor")
    ResponseEntity<ApiInstructorResponse<List<Instructor>>> addInstructor (@RequestBody InstructorRequest instructorRequest){
        ApiInstructorResponse<List<Instructor>> apiInstructorResponse = ApiInstructorResponse.<List<Instructor>>builder()
                .message("The instructor has been successfully added.")
                .payload(instructorService.addInstructor(instructorRequest))
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }

    @GetMapping("{instructor-id}")
    @Operation(summary = "Get instructor by id")
    ResponseEntity<ApiInstructorResponse<List<Instructor>>> getInstructorById(@PathVariable("instructor-id") Integer id) {
        ApiInstructorResponse<List<Instructor>> apiInstructorResponse = ApiInstructorResponse.<List<Instructor>>builder()
                .message("The student has been successfully founded.")
                .payload(instructorService.getInstructorById(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }

    @PutMapping("{instructor-id}")
    @Operation(summary = "Update instructor")
    ResponseEntity<ApiInstructorResponse<List<Instructor>>> updateInstructor (
            @PathVariable("instructor-id") Integer id,
            @RequestBody InstructorRequest instructorRequest){
        ApiInstructorResponse<List<Instructor>> apiInstructorResponse = ApiInstructorResponse.<List<Instructor>>builder()
                .message("The instructor has been successfully updated.")
                .payload(instructorService.updateInstructor(id,instructorRequest))
                .status(HttpStatus.OK)

                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }

    @DeleteMapping("{instructor-id}")
    @Operation(summary = "Delete instructor")
    ResponseEntity<ApiInstructorResponse<List<Instructor>>> deleteInstructor(@PathVariable("instructor-id") Integer id) {
        ApiInstructorResponse<List<Instructor>> apiInstructorResponse = ApiInstructorResponse.<List<Instructor>>builder()
                .message("The instructor has been successfully removed.")
                .payload(instructorService.deleteInstructor(id))
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(apiInstructorResponse);
    }
}