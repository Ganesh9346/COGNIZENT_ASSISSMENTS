/*====================================================
EXERCISE 4 : FUNCTIONS

A function is a named PL/SQL block that accepts parameters, performs some operation and returns a value.

Advantages of Functions:
1. Code reusability.
2. Reduces duplicate code.
3. Easier maintenance.
4. Can be used inside SQL statements.
====================================================*/


/*====================================================
Scenario 1:
Calculate the age of a customer.
====================================================*/

CREATE OR REPLACE FUNCTION CalculateAge(
    p_dob IN DATE
)
RETURN NUMBER
IS
    v_age NUMBER;
BEGIN
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE,p_dob)/12);
    RETURN v_age;
END;
/

SELECT CalculateAge(TO_DATE('15-08-1995','DD-MM-YYYY'))
AS Age
FROM Dual;



/*====================================================
Scenario 2:
Calculate monthly installment for a loan. EMI Formula:
P * R * (1+R)^N / ((1+R)^N - 1)
====================================================*/

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount IN NUMBER,
    p_interest_rate IN NUMBER,
    p_years IN NUMBER
)
RETURN NUMBER
IS
    v_rate NUMBER;
    v_months NUMBER;
    v_emi NUMBER;
BEGIN
    v_rate := p_interest_rate / (12 * 100);
    v_months := p_years * 12;

    v_emi := (p_loan_amount * v_rate *
             POWER(1 + v_rate, v_months))
             /
             (POWER(1 + v_rate, v_months) - 1);

    RETURN ROUND(v_emi,2);
END;
/

SELECT CalculateMonthlyInstallment(500000,8,5)
AS Monthly_Installment
FROM Dual;



/*====================================================
Scenario 3:
Check whether an account has sufficient balance.
====================================================*/

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount IN NUMBER
)
RETURN BOOLEAN
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/