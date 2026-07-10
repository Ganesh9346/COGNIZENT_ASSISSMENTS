EXERCISE 1: CONTROL STRUCTURES
Control structures are used in PL/SQL to control the flow of execution of a program. They help in 
making decisions and repeating a set of statements.
The main control structures in PL/SQL are:
1. IF Statement
   It is used to execute statements based on a condition.

2. LOOP Statement
   It is used to execute a set of statements repeatedly.

3. FOR LOOP
   It is used when the number of iterations is known.

4. WHILE LOOP
   It executes statements until the given condition becomes false.

Control structures are useful in banking applications because operations such as updating records, 
checking conditions, and generating reports often need repeated execution and decision making.

DECLARE
    v_age NUMBER;
BEGIN
    FOR c IN (SELECT c.CustomerID, c.DOB, l.LoanID
              FROM Customers c
              JOIN Loans l
              ON c.CustomerID = l.CustomerID)
    LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12);

        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = c.LoanID;

            DBMS_OUTPUT.PUT_LINE('Discount applied to Customer ID '
                                 || c.CustomerID);
        END IF;
    END LOOP;

    COMMIT;
END;
/

// Scenario 2
ALTER TABLE Customers
ADD IsVIP VARCHAR2(5);
BEGIN
    FOR c IN (SELECT CustomerID, Balance
              FROM Customers)
    LOOP
        IF c.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = c.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP status updated successfully.');
END;
/

// Scenario 3
BEGIN
    FOR c IN (SELECT cu.Name,
                     l.LoanID,
                     l.EndDate
              FROM Customers cu
              JOIN Loans l
              ON cu.CustomerID = l.CustomerID
              WHERE l.EndDate BETWEEN SYSDATE
                                  AND SYSDATE + 30)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan '|| c.LoanID|| ' for customer '|| c.Name|| ' is due on '|| TO_CHAR(c.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/

