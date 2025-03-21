package org.example.homework_spring_002.repository;

import org.apache.ibatis.annotations.*;
import org.example.homework_spring_002.model.Dto.entity.Instructor;
import org.example.homework_spring_002.model.Dto.request.InstructorRequest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Mapper
public interface InstructorRepository {
    @Select("""
    SELECT * FROM instructor 
    LIMIT #{limit} OFFSET #{offset}
    """)
    @Results(id="instructorMapper" , value = {
            @Result(property = "instructorId", column ="instructor_id" ),
            @Result(property = "instructorName", column = "instructor_name")
    })
    List<Instructor> getAllInstructor(int limit, int offset);



    @Select("""
            INSERT INTO instructor (instructor_name, email) 
            VALUES (#{InstructorRequest.instructorName}, #{InstructorRequest.email})
            RETURNING * """)
    @ResultMap("instructorMapper")
    List<Instructor> addInstructor(@Param("InstructorRequest") InstructorRequest instructorRequest);

    @Select("""
        SELECT * FROM instructor WHERE instructor_id = #{id}
    """)
    @ResultMap("instructorMapper")
    List<Instructor> getInstructorById(Integer id);

    @Select("""
    UPDATE instructor SET instructor_name = #{InstructorRequest.instructorName} WHERE instructor_id = #{id}
    RETURNING * """)
    @ResultMap("instructorMapper")
    List<Instructor> updateInstructor(@Param("id") Integer id, @Param("InstructorRequest") InstructorRequest instructorRequest);
}
