CREATE OR REPLACE TRIGGER CASESTUDY.enroll_stdname
BEFORE INSERT ON CASESTUDY.STD_COURSE FOR EACH ROW
DECLARE
    v_student_name VARCHAR2(200); -- Assuming STD_NAME can be up to 100 characters
BEGIN
    -- Retrieve the student's name from the students table based on STD_ID
    SELECT STD_NAME INTO v_student_name FROM student WHERE STD_ID = :NEW.STD_ID;
    
    -- Assign the retrieved student's name to the STD_NAME column in std_course table
    :NEW.STD_NAME := v_student_name;

END;
/
