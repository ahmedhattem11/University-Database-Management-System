CREATE OR REPLACE TRIGGER delete_course_trigger
BEFORE DELETE ON course
FOR EACH ROW
BEGIN
    -- Delete related data from Std_Course table
    DELETE FROM Std_Course
    WHERE course_id = :OLD.course_ID;

    -- Delete related data from Evaluation table
    DELETE FROM Evaluation
    WHERE course_ID = :OLD.course_ID;

    -- The foreign key constraints will automatically delete related data from other tables
END delete_course_trigger;
/
