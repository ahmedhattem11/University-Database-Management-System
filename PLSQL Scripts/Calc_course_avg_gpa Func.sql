CREATE OR REPLACE FUNCTION calculate_course_avg_gpa(p_course_id IN NUMBER) RETURN NUMBER IS
    v_avg_gpa NUMBER;
BEGIN
    SELECT 
        AVG(g.POINTS) INTO v_avg_gpa
    FROM 
        evaluation e
    JOIN 
        grade g ON e.GRADE_ID = g.GRADE_ID
    WHERE 
        e.COURSE_ID = p_course_id;
    
    RETURN v_avg_gpa;
END calculate_course_avg_gpa;
/

set serveroutput on
DECLARE
    v_avg_gpa NUMBER;
BEGIN
    v_avg_gpa := calculate_course_avg_gpa(11); -- Replace 101 with the desired course ID
    DBMS_OUTPUT.PUT_LINE('Average GPA for Course 101: ' || v_avg_gpa);
END;
/

