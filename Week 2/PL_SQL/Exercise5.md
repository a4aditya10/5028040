## Triggers

### Scenario 1: Automatically update the last modified date when a customer's record is updated.
- Question: Write a trigger UpdateCustomerLastModified that updates the LastModified column of the Customers table to the current date whenever a customer's record is updated.
```sql
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
AFTER UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
```
### Scenario 2: Maintain an audit log for all transactions.
- Question: Write a trigger LogTransaction that inserts a record into an AuditLog table whenever a transaction is inserted into the Transactions table.
```sql
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (:NEW.TransactionID, :NEW.AccountID, :NEW.TransactionDate, :NEW.Amount, :NEW.TransactionType);
END;
```
### Scenario 3: Enforce business rules on deposits and withdrawals.
- Question: Write a trigger CheckTransactionRules that ensures withdrawals do not exceed the balance and deposits are positive before inserting a record into the Transactions table.
```sql
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    IF :NEW.TransactionType = 'Withdrawal' THEN
        DECLARE
            v_Balance NUMBER;
        BEGIN
            SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = :NEW.AccountID;

            IF v_Balance < :NEW.Amount THEN
                RAISE_APPLICATION_ERROR(-20002, 'Withdrawal amount exceeds balance');
            END IF;
        END;
    ELSIF :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20003, 'Deposit amount must be positive');
    END IF;
END;
```