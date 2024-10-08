## Error Handling

### Scenario 1: Handle exceptions during fund transfers between accounts.
- Question: Write a stored procedure SafeTransferFunds that transfers funds between two accounts. Ensure that if any error occurs (e.g., insufficient funds), an appropriate error message is logged and the transaction is rolled back.
```sql
CREATE OR REPLACE PROCEDURE SafeTransferFunds(p_FromAccountID NUMBER, p_ToAccountID NUMBER, p_Amount NUMBER) AS
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
END SafeTransferFunds;
```
### Scenario 2: Manage errors when updating employee salaries.
- Question: Write a stored procedure UpdateSalary that increases the salary of an employee by a given percentage. If the employee ID does not exist, handle the exception and log an error message.
```sql
CREATE OR REPLACE PROCEDURE UpdateSalary(p_EmployeeID NUMBER, p_Percentage NUMBER) AS
    v_Salary NUMBER;
BEGIN
    BEGIN
        SELECT Salary INTO v_Salary FROM Employees WHERE EmployeeID = p_EmployeeID;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            INSERT INTO ErrorLog (Message) VALUES ('Employee ID not found');
            RETURN;
    END;

    UPDATE Employees SET Salary = Salary * (1 + p_Percentage/100) WHERE EmployeeID = p_EmployeeID;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (Message) VALUES (SQLERRM);
END UpdateSalary;
```
### Scenario 3: Ensure data integrity when adding a new customer.
- Question: Write a stored procedure AddNewCustomer that inserts a new customer into the Customers table. If a customer with the same ID already exists, handle the exception by logging an error and preventing the insertion.
```sql
CREATE OR REPLACE PROCEDURE AddNewCustomer(p_CustomerID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER) AS
BEGIN
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified) VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            INSERT INTO ErrorLog (Message) VALUES ('Customer with the same ID already exists');
    END;
END AddNewCustomer;
```

