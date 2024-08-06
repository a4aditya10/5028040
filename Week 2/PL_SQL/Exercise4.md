## Functions

### Scenario 1: Calculate the age of customers for eligibility checks.
- Question: Write a function CalculateAge that takes a customer's date of birth as input and returns their age in years
```sql
CREATE OR REPLACE FUNCTION CalculateAge(p_DOB DATE) RETURN NUMBER IS
BEGIN
    RETURN TRUNC(MONTHS_BETWEEN(SYSDATE, p_DOB) / 12);
END CalculateAge;
```

### Scenario 2: The bank needs to compute the monthly installment for a loan.
- Question: Write a function CalculateMonthlyInstallment that takes the loan amount, interest rate, and loan duration in years as input and returns the monthly installment amount.
```sql
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(p_LoanAmount NUMBER, p_InterestRate NUMBER, p_DurationYears NUMBER) RETURN NUMBER IS
    v_MonthlyRate NUMBER;
    v_TotalMonths NUMBER;
BEGIN
    v_MonthlyRate := p_InterestRate / 1200;
    v_TotalMonths := p_DurationYears * 12;

    RETURN (p_LoanAmount * v_MonthlyRate) / (1 - POWER(1 + v_MonthlyRate, -v_TotalMonths));
END CalculateMonthlyInstallment;
```
### Scenario 3: Check if a customer has sufficient balance before making a transaction.
- Question: Write a function HasSufficientBalance that takes an account ID and an amount as input and returns a boolean indicating whether the account has at least the specified amount.
```sql
CREATE OR REPLACE FUNCTION HasSufficientBalance(p_AccountID NUMBER, p_Amount NUMBER) RETURN BOOLEAN IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = p_AccountID;

    IF v_Balance >= p_Amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END HasSufficientBalance;
```