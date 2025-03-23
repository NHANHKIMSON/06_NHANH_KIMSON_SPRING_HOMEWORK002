package org.example.homework_spring_002.model.Dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.homework_spring_002.model.Dto.entity.Course;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {
    private String StudentName;
    private String email;
    private String phoneNumber;
    private List<Integer> courses;
}
