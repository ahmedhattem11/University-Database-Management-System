CREATE OR REPLACE TRIGGER insert_course_name
before insert on std_course 
FOR EACH ROW 
DECLARE 
    v_course_name VARCHAR2(255);
BEGIN
    select course_name into v_course_name from course where course_id = :NEW.COURSE_ID;
    
    :NEW.COURSE_NAME := v_course_name; 
    
END; 
show errors