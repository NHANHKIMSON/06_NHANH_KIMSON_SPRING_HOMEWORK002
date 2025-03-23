package org.example.homework_spring_002.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework_spring_002.model.Dto.entity.Course;
import org.example.homework_spring_002.model.Dto.request.CourseRequest;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("""
            SELECT * FROM course
            offset #{size} * (#{page} - 1)
            limit #{size}
            """)
    @Results(id =  "courseRequest" ,value = {
            @Result(property = "id", column = "course_id"),
            @Result(property = "name", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id",
            one = @One(select = "org.example.homework_spring_002.repository.InstructorRepository.getInstructorById"))
    })
    List<Course> getAllCourse(int page, int size);

    @Select("""
            SELECT * FROM course WHERE course_id = #{id}
            """)
    @ResultMap("courseRequest")
    List<Course> getCourseById(@Param("id") Integer id);


    @Select("""
            DELETE FROM course WHERE course_id = #{id}
            RETURNING *
            """)
    @ResultMap("courseRequest")
    List<Course> deleteCourse(@Param("id") Integer id);


    @Select("""
            INSERT INTO course(course_name, description, instructor_id)
            VALUES (#{courseRequest.courseName}, #{courseRequest.description}, #{courseRequest.instructorId})
            RETURNING * """)
    @ResultMap("courseRequest")
    List<Course> addCourse(@Param("courseRequest") CourseRequest courseRequest);

    @Insert("""
    INSERT INTO student_course(student_id, course_id)
    VALUES (#{studentId},#{courseId})
    """)
    void insertStudentCourse(Integer studentId, Integer courseId);

    @Delete("""
    DELETE FROM student_course WHERE student_id = #{studentId}
    """)
    void deleteStudentCourse(Integer studentId);



    @Select("""
    UPDATE course SET course_name = #{courseRequest.courseName}, description = #{courseRequest.description}, instructor_id = #{courseRequest.instructorId}  WHERE course_id = #{id}
    RETURNING * """)
    @ResultMap("courseRequest")
    List<Course> updateCourse(Integer studentId, @Param("courseRequest")  CourseRequest courseRequest);


    @Select("""
            SELECT course.course_id, course_name, description, instructor_id  FROM course INNER JOIN
                                                                                   student_course sc on course.course_id = sc.course_id
            WHERE student_id = #{id};
            """)
    @ResultMap("courseRequest")
    List<Course> getCourseByStudentId(Integer id);
}
