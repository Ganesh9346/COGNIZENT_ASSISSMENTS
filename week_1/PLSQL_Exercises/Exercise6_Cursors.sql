/*====================================================
EXERCISE 6 : CURSORS

A cursor is used to process query results one row at a time. Explicit cursors are created by the programmer and
are useful when each row needs individual processing.

Advantages of Cursors:
1. Process records one by one.
2. Useful for reports and statements.
3. Helpful for batch updates.
4. Provides more control over query results.
====================================================*/


/*====================================================
Scenario 1:
Generate monthly statements for all customers.
====================================================*/

DECLARE
    CURSOR c_trans IS
    SELECT CustomerID,
           TransactionID,
           Amount,
           TransactionDate
    FROM Transactions
    WHERE EXTRACT(MONTH FROM TransactionDate) =
          EXTRACT(MONTH FROM SYSDATE)
      AND EXTRACT(YEAR FROM TransactionDate) =
          EXTRACT(YEAR FROM SYSDATE);

    v_customerid Transactions.CustomerID%TYPE;
    v_transid Transactions.TransactionID%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_date Transactions.TransactionDate%TYPE;

BEGIN
    OPEN c_trans;

    LOOP
        FETCH c_trans
        INTO v_customerid,
             v_transid,
             v_amount,
             v_date;

        EXIT WHEN c_trans%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer ID : ' || v_customerid ||
            ' Transaction ID : ' || v_transid ||
            ' Amount : ' || v_amount ||
            ' Date : ' || v_date
        );
    END LOOP;

    CLOSE c_trans;
END;
/



/*====================================================
Scenario 2:
Deduct annual maintenance fee from all accounts.
====================================================*/

DECLARE
    CURSOR c_acc IS
    SELECT AccountID
    FROM Accounts;

    v_accid Accounts.AccountID%TYPE;
    v_fee NUMBER := 500;

BEGIN
    OPEN c_acc;

    LOOP
        FETCH c_acc INTO v_accid;

        EXIT WHEN c_acc%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE AccountID = v_accid;
    END LOOP;

    CLOSE c_acc;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Annual maintenance fee deducted.'
    );
END;
/



/*====================================================
Scenario 3:
Update interest rates for all loans.
Increase interest rate by 0.5%.
====================================================*/

DECLARE
    CURSOR c_loan IS
    SELECT LoanID
    FROM Loans;

    v_loanid Loans.LoanID%TYPE;

BEGIN
    OPEN c_loan;

    LOOP
        FETCH c_loan INTO v_loanid;

        EXIT WHEN c_loan%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = v_loanid;
    END LOOP;

    CLOSE c_loan;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Loan interest rates updated.'
    );
END;
/