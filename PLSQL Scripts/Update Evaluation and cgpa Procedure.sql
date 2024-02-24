CREATE OR REPLACE PROCEDURE update_evaluation_and_cgpa(
    p_std_id IN NUMBER,
    p_course_id IN NUMBER,
    p_semester IN NUMBER,
    p_grade_id IN VARCHAR2
) AS
    total_credits DECIMAL(5, 2) := 0;
    total_grade_points DECIMAL(5, 2) := 0;
    new_cgpa DECIMAL(5, 2) := 0;
BEGIN
    -- Update the grade_id in the evaluation table
    UPDATE evaluation
    SET grade_id = p_grade_id
    WHERE std_id = p_std_id
    AND course_id = p_course_id
    AND semester = p_semester;

    -- Calculate total credits and total grade points for the student
    SELECT SUM(e.credit_hours), SUM(e.credit_hours * g.points)
    INTO total_credits, total_grade_points
    FROM evaluation e
    JOIN grade g ON e.grade_id = g.grade_id
    WHERE e.std_id = p_std_id;

    -- Calculate new CGPA
    IF total_credits > 0 THEN
        new_cgpa := total_grade_points / total_credits;
    ELSE
        new_cgpa := NULL; -- Handle division by zero
    END IF;

    -- Update CGPA in students table
    UPDATE student
    SET CGPA = new_cgpa
    WHERE std_id = p_std_id;
END;
/

BEGIN
    update_evaluation_and_cgpa(p_std_id => 1, p_course_id => 11, p_semester => 1, p_grade_id => 'A');
END;
/
