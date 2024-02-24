CREATE OR REPLACE TRIGGER delete_department_trigger
BEFORE DELETE ON department
FOR EACH ROW
BEGIN
    -- Delete related records from std_course table
    DELETE FROM std_course WHERE std_course.dep_ID = :OLD.dep_ID;

    -- Delete related records from evaluation table
    DELETE FROM evaluation WHERE evaluation.dep_ID = :OLD.dep_ID;
END;
/
