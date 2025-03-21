package org.example.homework_spring_002.model.Dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiInstructorResponse<T> {
    private String message;
    private T payload;
    private HttpStatus status;
    private LocalDateTime timestamp;
}
