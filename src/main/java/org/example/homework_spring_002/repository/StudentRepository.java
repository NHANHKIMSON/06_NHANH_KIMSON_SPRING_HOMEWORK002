package org.example.homework_spring_002.repository;


import lombok.Data;
import org.apache.ibatis.annotations.*;
import org.example.homework_spring_002.model.Dto.entity.Student;
import org.example.homework_spring_002.model.Dto.request.StudentRequest;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("""
            SELECT * FROM student\s
            OFFSET ${size} * (${page} - 1)
            LIMIT #{size}
           \s""")
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "course", column = "student_id", many = @Many(select = "org.example.homework_spring_002.repository.CourseRepository.getCourseByStudentId"))
    } )
    List<Student> getAllStudents(int page, int size);

    @Select("""
        SELECT * FROM student WHERE student_id = #{studentId}
        """)
    @ResultMap("studentMapper")
    List<Student> getStudentsById(Integer studentId);

    @Select("""
        DELETE FROM student WHERE student_id = #{studentId}
        RETURNING *
        """)
    @ResultMap("studentMapper")
    List<Student> deleteStudentById(Integer studentId);

    @Select("""
    INSERT INTO student(student_name, email, phone_number)
    VALUES (#{StudentRequest.studentName}, #{StudentRequest.email},
            #{StudentRequest.phoneNumber})
    RETURNING *
    """)
    @ResultMap("studentMapper")
    Student addNewStudent(@Param("StudentRequest") StudentRequest studentRequest);

    @Select("""
    INSERT INTO student_course (student_id, course_id) 
    VALUES (#{studentId}, #{courseId})
    """)
    void insertStudentCourse(@Param("StudentId") Integer studentId, @Param("CourseId") Integer courseId);



    @Select("""
    UPDATE student 
    SET student_name = #{studentRequest.studentName},
        email = #{studentRequest.email},
        phone_number = #{studentRequest.phoneNumber}
    WHERE student_id = #{studentId}  
    RETURNING *
    """)
    @ResultMap("studentMapper")
    Student updateStudent(Integer studentId, @Param("studentRequest") StudentRequest studentRequest);
}
