CREATE OR REPLACE TRIGGER enroll_into_eval
AFTER INSERT ON STD_COURSE
FOR EACH ROW
DECLARE
    v_credit_hours NUMBER;
BEGIN
    SELECT credit_hours INTO v_credit_hours FROM course WHERE course_id = :NEW.COURSE_ID;
    
    INSERT INTO evaluation (STD_ID, STD_NAME, COURSE_ID, COURSE_NAME, GRADE_ID, CREDIT_HOURS, SEMESTER)
    VALUES (:NEW.STD_ID, :NEW.STD_NAME, :NEW.COURSE_ID, :NEW.COURSE_NAME, NULL, v_credit_hours, :NEW.SEMESTER);

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
        ROLLBACK; -- Rollback the transaction if an error occurs
END;
/
