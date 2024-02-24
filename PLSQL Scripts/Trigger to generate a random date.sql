CREATE OR REPLACE TRIGGER generate_evaluation_date
BEFORE INSERT ON evaluation
FOR EACH ROW
DECLARE
    v_evaluation_date DATE;
BEGIN
    -- Seed the random number generator with a unique value based on the current system time
    DBMS_RANDOM.SEED(TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS'));

    -- Generate a random evaluation date based on the semester
    IF :NEW.SEMESTER = 1 THEN
        -- Generate a random date in January
        v_evaluation_date := TO_DATE('01/' || TO_CHAR(DBMS_RANDOM.VALUE(1, 31), 'FM00') || '/' || TO_CHAR(SYSDATE, 'YYYY'), 'MM/DD/YYYY');
    ELSIF :NEW.SEMESTER = 2 THEN
        -- Generate a random date in June
        v_evaluation_date := TO_DATE('06/' || TO_CHAR(DBMS_RANDOM.VALUE(1, 30), 'FM00') || '/' || TO_CHAR(SYSDATE, 'YYYY'), 'MM/DD/YYYY');
    END IF;

    -- Assign the generated evaluation date to the EVALUATION_DATE column
    :NEW.EVALUATION_DATE := v_evaluation_date;
END;
/
