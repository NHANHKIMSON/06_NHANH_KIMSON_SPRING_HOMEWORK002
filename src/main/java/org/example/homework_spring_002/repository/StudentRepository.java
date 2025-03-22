package org.example.homework_spring_002.repository;


import org.apache.ibatis.annotations.*;
import org.example.homework_spring_002.model.Dto.entity.Course;
import org.example.homework_spring_002.model.Dto.entity.Student;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("""
            SELECT * FROM student\s
           \s""")
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "course", column = "student_id", many = @Many(select = "org.example.homework_spring_002.repository.CourseRepository.getCourseByStudentId"))
    } )
    List<Student> getAllStudents();

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
}
