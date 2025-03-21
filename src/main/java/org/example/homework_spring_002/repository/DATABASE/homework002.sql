-- Instructor Table
CREATE TABLE instructor (
                            instructor_id SERIAL PRIMARY KEY,
                            instructor_name VARCHAR(100) NOT NULL,
                            email VARCHAR(100) UNIQUE NOT NULL
);

-- Course Table
CREATE TABLE course (
                        course_id SERIAL PRIMARY KEY,
                        course_name VARCHAR(150) NOT NULL,
                        description TEXT,
                        instructor_id INT,
                        FOREIGN KEY (instructor_id) REFERENCES instructor(instructor_id) ON DELETE SET NULL
);

-- Student Table
CREATE TABLE student (
                         student_id SERIAL PRIMARY KEY,
                         student_name VARCHAR(100) NOT NULL,
                         email VARCHAR(100) UNIQUE NOT NULL,
                         phone_number VARCHAR(20) NOT NULL
);

-- Student-Course (Many-to-Many Relationship)
CREATE TABLE student_course (
                                student_id INT NOT NULL,
                                course_id INT NOT NULL,
                                PRIMARY KEY (student_id, course_id),
                                FOREIGN KEY (student_id) REFERENCES student(student_id) ON DELETE CASCADE,
                                FOREIGN KEY (course_id) REFERENCES course(course_id) ON DELETE CASCADE
);