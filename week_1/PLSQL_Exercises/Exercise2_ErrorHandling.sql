/*====================================================
EXERCISE 2 : ERROR HANDLING

Exception handling is used in PL/SQL to handle runtime errors without stopping the program unexpectedly.

The EXCEPTION block is used to handle errors that occur
during program execution.

Common exceptions:
1. NO_DATA_FOUND
2. DUP_VAL_ON_INDEX
3. TOO_MANY_ROWS
4. ZERO_DIVIDE

Exception handling is important because it maintains data integrity and prevents incorrect transactions.
====================================================*/


/*====================================================
Scenario 1:
Handle exceptions during fund transfers between accounts.
====================================================*/

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_acc IN NUMBER,
    p_to_acc IN NUMBER,
    p_amount IN NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_acc;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001,'Insufficient Balance');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_acc;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_acc;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Amount transferred successfully.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Account not found.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error : ' || SQLERRM);
END;
/

EXEC SafeTransferFunds(1,2,500);



/*====================================================
Scenario 2:
Manage errors when updating employee salaries.
====================================================*/

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_empid IN NUMBER,
    p_percent IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmployeeID = p_empid;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE NO_DATA_FOUND;
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee ID does not exist.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error : ' || SQLERRM);
END;
/

EXEC UpdateSalary(1,10);



/*====================================================
Scenario 3:
Ensure data integrity when adding a new customer.
====================================================*/

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
)
IS
BEGIN
    INSERT INTO Customers
    VALUES(p_id,
           p_name,
           p_dob,
           p_balance,
           SYSDATE);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Customer ID already exists.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error : ' || SQLERRM);
END;
/

EXEC AddNewCustomer(3,
                    'David',
                    TO_DATE('1995-04-10','YYYY-MM-DD'),
                    5000);