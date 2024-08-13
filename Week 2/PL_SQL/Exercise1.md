## Control Structures

### Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
- Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates.
```sql
BEGIN
    FOR rec IN (SELECT * FROM Customers) LOOP
        IF EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM rec.DOB) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
END;
```
### Scenario 2: A customer can be promoted to VIP status based on their balance.
- Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP to TRUE for those with a balance over $10,000.
```sql
BEGIN
    FOR rec IN (SELECT * FROM Customers) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = TRUE
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
END;
```
### Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.
- Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a reminder message for each customer
``` sql
BEGIN
    FOR rec IN (SELECT * FROM Loans WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Your loan payment is due in ' || rec.EndDate - SYSDATE || ' days.');
    END LOOP;
END;
```


