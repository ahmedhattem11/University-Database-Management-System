-- Department Table
CREATE TABLE Department (
    dep_ID NUMBER PRIMARY KEY,
    dep_name VARCHAR2(255),
    dep_head VARCHAR2(255),
    e_mail VARCHAR2(255) UNIQUE,
    instructor_count NUMBER,
    std_count NUMBER
);

-- Student Table
CREATE TABLE Student (
    std_ID NUMBER PRIMARY KEY,
    f_name VARCHAR2(255),
    l_name VARCHAR2(255),
    cgpa NUMBER(4, 3),
    dep_ID NUMBER,
    mobile_num VARCHAR2(15),
    st_num VARCHAR2(10),
    city VARCHAR2(255),
    e_mail VARCHAR2(255) UNIQUE, -- Added UNIQUE constraint
    gender CHAR(1),
    dob DATE,
    CONSTRAINT fk_student_department
        FOREIGN KEY (dep_ID) REFERENCES Department(dep_ID)
);

-- Course Table
CREATE TABLE Course (
    course_id NUMBER PRIMARY KEY,
    course_name VARCHAR2(255),
    credit_hours NUMBER,
    capacity NUMBER,
    dep_ID NUMBER,
    CONSTRAINT fk_course_department
        FOREIGN KEY (dep_ID) REFERENCES Department(dep_ID)
);

-- Std_Course Table
CREATE TABLE Std_Course (
    std_ID NUMBER,
    std_name VARCHAR2(255),
    course_ID NUMBER,
    course_name VARCHAR2(255),
    semester NUMBER,
    PRIMARY KEY (std_ID, course_ID, semester),
    CONSTRAINT fk_std_course_student
        FOREIGN KEY (std_ID) REFERENCES Student(std_ID),
    CONSTRAINT fk_std_course_course
        FOREIGN KEY (course_ID) REFERENCES Course(course_id)
);

-- Grade Table
CREATE TABLE Grade (
    grade_ID VARCHAR2(15) PRIMARY KEY,
    points NUMBER(4, 3) NOT NULL,
    grade_status VARCHAR2(255) NOT NULL
);

-- Evaluation Table
CREATE TABLE Evaluation (
    std_ID NUMBER,
    std_name VARCHAR2(255),
    course_ID NUMBER,
    course_name VARCHAR2(255),
    grade_ID VARCHAR2(15),
    credit_hours NUMBER,
    evaluation_date DATE,
    semester NUMBER,
    PRIMARY KEY (std_ID, course_ID, semester),
    CONSTRAINT fk_evaluation_student
        FOREIGN KEY (std_ID) REFERENCES Student(std_ID),
    CONSTRAINT fk_evaluation_course
        FOREIGN KEY (course_ID) REFERENCES Course(course_id),
    CONSTRAINT fk_evaluation_grade
        FOREIGN KEY (grade_ID) REFERENCES Grade(grade_ID)
);

-- Inserting data for the first row
INSERT INTO evaluation (Std_ID, Std_Name, Course_ID, Course_Name, Grade_ID, Credit_hours, Evaluation_Date, Semester)
VALUES (1, 'John Doe', 11, 'SQL', 'B', 3, TO_DATE('2023-01-20', 'YYYY-MM-DD'), 1);

-- Inserting data for the last row
INSERT INTO evaluation (Std_ID, Std_Name, Course_ID, Course_Name, Grade_ID, Credit_hours, Evaluation_Date, Semester)
VALUES (12, 'Emma Davis', 24, 'Ethical Hacking', 'F', 3, TO_DATE('2023-06-15', 'YYYY-MM-DD'), 2);

