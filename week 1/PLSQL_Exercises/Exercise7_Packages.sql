/*====================================================
EXERCISE 7 : PACKAGES

A package is a collection of related procedures, functions, variables and cursors stored together in the
database.

Advantages of Packages:
1. Better code organization.
2. Improves code reusability.
3. Easier maintenance.
4. Better security and performance.
====================================================*/


/*====================================================
Scenario 1:
Customer Management Package
====================================================*/

CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(
        p_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_id NUMBER,
        p_name VARCHAR2
    );

    FUNCTION GetCustomerBalance(
        p_id NUMBER
    ) RETURN NUMBER;
END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_id NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Customers
        VALUES(p_id,p_name,p_dob,p_balance,SYSDATE);

        COMMIT;
    END;

    PROCEDURE UpdateCustomer(
        p_id NUMBER,
        p_name VARCHAR2
    )
    IS
    BEGIN
        UPDATE Customers
        SET Name = p_name
        WHERE CustomerID = p_id;

        COMMIT;
    END;

    FUNCTION GetCustomerBalance(
        p_id NUMBER
    )
    RETURN NUMBER
    IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE CustomerID = p_id;

        RETURN v_balance;
    END;

END CustomerManagement;
/



/*====================================================
Scenario 2:
Employee Management Package
====================================================*/

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_dept VARCHAR2,
        p_salary NUMBER
    );

    PROCEDURE UpdateEmployee(
        p_id NUMBER,
        p_salary NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_id NUMBER
    ) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_dept VARCHAR2,
        p_salary NUMBER
    )
    IS
    BEGIN
        INSERT INTO Employees
        VALUES(p_id,p_name,p_dept,p_salary);

        COMMIT;
    END;

    PROCEDURE UpdateEmployee(
        p_id NUMBER,
        p_salary NUMBER
    )
    IS
    BEGIN
        UPDATE Employees
        SET Salary = p_salary
        WHERE EmployeeID = p_id;

        COMMIT;
    END;

    FUNCTION CalculateAnnualSalary(
        p_id NUMBER
    )
    RETURN NUMBER
    IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_id;

        RETURN v_salary * 12;
    END;

END EmployeeManagement;
/



/*====================================================
Scenario 3:
Account Operations Package
====================================================*/

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount(
        p_accid NUMBER,
        p_custid NUMBER,
        p_type VARCHAR2,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_accid NUMBER
    );

    FUNCTION GetTotalBalance(
        p_custid NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_accid NUMBER,
        p_custid NUMBER,
        p_type VARCHAR2,
        p_balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Accounts
        VALUES(p_accid,p_custid,p_type,p_balance);

        COMMIT;
    END;

    PROCEDURE CloseAccount(
        p_accid NUMBER
    )
    IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_accid;

        COMMIT;
    END;

    FUNCTION GetTotalBalance(
        p_custid NUMBER
    )
    RETURN NUMBER
    IS
        v_total NUMBER;
    BEGIN
        SELECT SUM(Balance)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_custid;

        RETURN NVL(v_total,0);
    END;

END AccountOperations;
/