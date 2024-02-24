CREATE OR REPLACE TRIGGER unenroll_student
BEFORE DELETE ON evaluation
FOR EACH ROW
BEGIN
    DELETE FROM std_course
    WHERE std_id = :OLD.std_id
    and course_id = :OLD.course_id
    and semester = :OLD.semester;
END;
/


