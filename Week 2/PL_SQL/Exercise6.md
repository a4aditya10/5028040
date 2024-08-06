## Cursors

### Scenario 1: Generate monthly statements for all customers.
- Question: Write a PL/SQL block using an explicit cursor GenerateMonthlyStatements that retrieves all transactions for the current month and prints a statement for each customer.
```sql
DECLARE
    CURSOR c_Transactions IS
        SELECT * FROM Transactions WHERE TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND LAST_DAY(SYSDATE);
BEGIN
    FOR rec IN c_Transactions LOOP
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || rec.CustomerID || ' - Transaction ID: ' || rec.TransactionID || ' - Amount: ' || rec.Amount);
    END LOOP;
END;
```
### Scenario 2: Apply annual fee to all accounts.
- Question: Write a PL/SQL block using an explicit cursor ApplyAnnualFee that deducts an annual maintenance fee from the balance of all accounts.
```sql
DECLARE
    CURSOR c_Accounts IS
        SELECT * FROM Accounts;
BEGIN
    FOR rec IN c_Accounts LOOP
        UPDATE Accounts
        SET Balance = Balance - 100 -- Assume $100 annual fee
        WHERE AccountID = rec.AccountID;
    END LOOP;

    COMMIT;
END;
```
### Scenario 3: Update the interest rate for all loans based on a new policy.
- Question: Write a PL/SQL block using an explicit cursor UpdateLoanInterestRates that fetches all loans and updates their interest rates based on the new policy.
```sql
DECLARE
    CURSOR c_Loans IS
        SELECT * FROM Loans;
BEGIN
    FOR rec IN c_Loans LOOP
        UPDATE Loans
        SET InterestRate = rec.InterestRate + 0.5 -- Assume 0.5% increase
        WHERE LoanID = rec.LoanID;
    END LOOP;

    COMMIT;
END;
```