## Stored Procedures

### Scenario 1: The bank needs to process monthly interest for all savings accounts.
- Question: Write a stored procedure ProcessMonthlyInterest that calculates and updates the balance of all savings accounts by applying an interest rate of 1% to the current balance.
```sql
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR rec IN (SELECT * FROM Accounts WHERE AccountType = 'Savings') LOOP
        UPDATE Accounts
        SET Balance = Balance * 1.01
        WHERE AccountID = rec.AccountID;
    END LOOP;

    COMMIT;
END ProcessMonthlyInterest;
```

### Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.
- Question: Write a stored procedure UpdateEmployeeBonus that updates the salary of employees in a given department by adding a bonus percentage passed as a parameter.
```sql
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_Department VARCHAR2, p_BonusPercentage NUMBER) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_BonusPercentage / 100)
    WHERE Department = p_Department;

    COMMIT;
END UpdateEmployeeBonus;
```
### Scenario 3: Customers should be able to transfer funds between their accounts.
- Question: Write a stored procedure TransferFunds that transfers a specified amount from one account to another, checking that the source account has sufficient balance before making the transfer.
```sql
CREATE OR REPLACE PROCEDURE TransferFunds(p_FromAccountID NUMBER, p_ToAccountID NUMBER, p_Amount NUMBER) AS
    v_FromBalance NUMBER;
BEGIN
    SELECT Balance INTO v_FromBalance FROM Accounts WHERE AccountID = p_FromAccountID;

    IF v_FromBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds');
    END IF;

    UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_FromAccountID;
    UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_ToAccountID;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (Message) VALUES (SQLERRM);
END TransferFunds;
```
