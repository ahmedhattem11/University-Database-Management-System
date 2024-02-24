-- Create Student table
CREATE TABLE Student (
    std_ID INT PRIMARY KEY,
    f_name VARCHAR(255),
    l_name VARCHAR(255),
    cgpa DECIMAL(4, 2),
    dep_id INT,
    st_num VARCHAR(90),
    city VARCHAR(90),
    email VARCHAR(255),
    gender CHAR(1),
    dob DATE,
    FOREIGN KEY (dep_id) REFERENCES Department(dep_ID)
);

-- Create Student_mobile table
CREATE TABLE Student_mobile (
    std_ID INT,
    mobile_num int,
    PRIMARY KEY (std_ID, mobile_num),
    FOREIGN KEY (std_ID) REFERENCES Student(std_ID)
);

-- Create Department table
CREATE TABLE Department (
    dep_ID INT PRIMARY KEY,
    dep_name VARCHAR(255),
    dep_head VARCHAR(255),
    email VARCHAR(255),
    instructor_count INT,
    std_count INT
);

-- Create Department_contact table
CREATE TABLE Department_contact (
    dep_ID INT,
    contact_num VARCHAR(15),
     PRIMARY KEY (dep_ID, contact_num),
    FOREIGN KEY (dep_ID) REFERENCES Department(dep_ID)
);

-- Create Course table
CREATE TABLE Course (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(255),
    credit_hours INT,
    capacity INT,
    dep_ID INT,
    FOREIGN KEY (dep_ID) REFERENCES Department(dep_ID)
);

-- Create Std_Course table
CREATE TABLE Std_Course (
    std_ID INT,
    std_name VARCHAR(255),
    course_ID INT,
    course_name VARCHAR(255),
    semester int,
    PRIMARY KEY (std_ID, course_ID, semester),
    FOREIGN KEY (std_ID) REFERENCES Student(std_ID),
    FOREIGN KEY (course_ID) REFERENCES Course(course_id)
);

-- Create Grade table
CREATE TABLE Grade (
    grade_ID varchar(10) PRIMARY KEY,
    points DECIMAL(4, 2) NOT NULL,
    grade_status VARCHAR(200) NOT NULL
);

-- Create Evaluation table
CREATE TABLE Evaluation (
    std_ID INT,
    std_name VARCHAR(255),
    course_ID INT,
    course_name VARCHAR(255),
    grade_ID varchar(10),
    evaluation_date DATE,
    semester VARCHAR(20),
    PRIMARY KEY (std_ID, course_ID, semester),
    FOREIGN KEY (std_ID) REFERENCES Student(std_ID),
    FOREIGN KEY (course_ID) REFERENCES Course(course_id),
    FOREIGN KEY (grade_ID) REFERENCES Grade(grade_ID)
);
