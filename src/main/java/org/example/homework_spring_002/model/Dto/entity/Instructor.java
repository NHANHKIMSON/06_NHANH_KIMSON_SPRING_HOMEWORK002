package org.example.homework_spring_002.model.Dto.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {
    private Integer instructorId;
    private String instructorName;
    private String email;
}
