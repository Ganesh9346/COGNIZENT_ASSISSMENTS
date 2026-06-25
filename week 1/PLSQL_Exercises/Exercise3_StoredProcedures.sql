/*====================================================
EXERCISE 3 : STORED PROCEDURES

A stored procedure is a named PL/SQL block that is stored in the database and can be executed whenever
required.

Advantages of Stored Procedures:
1. Improves code reusability.
2. Reduces network traffic.
3. Improves security.
4. Makes applications easier to maintain.
====================================================*/


/*====================================================
Scenario 1:
Process monthly interest for all savings accounts. Apply 1% interest to the current balance.
====================================================*/

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully.');
END;
/

EXEC ProcessMonthlyInterest;


/*====================================================
Scenario 2:
Update employee salary by adding a bonus percentage for a given department.
====================================================*/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus / 100)
    WHERE Department = p_department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Employee bonus updated successfully.');
END;
/

EXEC UpdateEmployeeBonus('IT',10);


/*====================================================
Scenario 3:
Transfer funds between two accounts.
====================================================*/

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_acc IN NUMBER,
    p_to_acc IN NUMBER,
    p_amount IN NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_acc;

    IF v_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    ELSE
        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_acc;

        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_acc;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Fund transfer successful.');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account not found.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error : ' || SQLERRM);
END;
/

EXEC TransferFunds(1,2,1000);