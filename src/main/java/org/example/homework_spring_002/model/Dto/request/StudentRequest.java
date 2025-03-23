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

    private String studentName;
    private String phoneNumber;
    private String email;
    private List<Integer> courses;

}
