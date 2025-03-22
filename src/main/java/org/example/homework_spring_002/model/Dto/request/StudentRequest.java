package org.example.homework_spring_002.model.Dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class StudentRequest {
    private String name;
    private String email;
    private String phone;
}
