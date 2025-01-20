After pulling this need to add some trigger and procedure in DB because if any new employee is added or deleted so that can manage the chart .
crate a db in mysql ---> employee_performance(or you can create with your own but then need to change the db  in pom xml file )
procedure---->
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_category_percentages`()
BEGIN
    DECLARE total_employees INT;

   
    SELECT COUNT(*) INTO total_employees FROM employee_details;

    
    UPDATE category
    SET actual = (
        SELECT (COUNT(*) * 100.0) / total_employees
        FROM employee_details
        WHERE employee_details.rating = category.rating
    );
END
--------------------------------------------------------------------------------
trigger for inserting new emp(on employee table)

CREATE OR REPLACE TRIGGER trg_employee_insert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    UPDATE summary
    SET actual = actual + 1
    WHERE rating = :NEW.rating;
END;
/
-------------------------------------------------------------------------------
trigger on deleting the emp 

CREATE OR REPLACE TRIGGER trg_employee_delete
AFTER DELETE ON employee
FOR EACH ROW
BEGIN
    UPDATE summary
    SET actual = actual - 1
    WHERE rating = :OLD.rating;
END;
/
--------------------------------------------------------
trigger for updating the emp

CREATE OR REPLACE TRIGGER trg_employee_update
AFTER UPDATE ON employee
FOR EACH ROW
BEGIN
   
    UPDATE summary
    SET actual = actual - 1
    WHERE rating = :OLD.rating;   
    UPDATE summary
    SET actual = actual + 1
    WHERE rating = :NEW.rating;
END;
/
------------------------------------------
