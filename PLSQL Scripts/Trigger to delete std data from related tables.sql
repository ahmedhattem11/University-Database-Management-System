CREATE OR REPLACE TRIGGER delete_student_data_trigger
BEFORE DELETE ON Student
FOR EACH ROW
BEGIN
    -- Delete related data from Std_Course table
    DELETE FROM Std_Course
    WHERE std_ID = :OLD.std_ID;

    -- Delete related data from Evaluation table
    DELETE FROM Evaluation
    WHERE std_ID = :OLD.std_ID;

    -- The foreign key constraints will automatically delete related data from other tables
END delete_student_data_trigger;
/
