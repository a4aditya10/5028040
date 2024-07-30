class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size == employees.length) {
            System.out.println("Array is full");
            return;
        }
        employees[size++] = employee;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId.equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println("ID: " + employees[i].employeeId + ", Name: " + employees[i].name + 
                               ", Position: " + employees[i].position + ", Salary: " + employees[i].salary);
        }
    }

    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId.equals(employeeId)) {
                employees[i] = employees[size - 1];
                size--;
                return;
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Initialize the employee management system with a capacity of 5 employees
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        // Create some employee objects
        Employee employee1 = new Employee("E001", "Alice", "Manager", 75000);
        Employee employee2 = new Employee("E002", "Bob", "Developer", 65000);
        Employee employee3 = new Employee("E003", "Charlie", "Designer", 60000);
        Employee employee4 = new Employee("E004", "David", "Tester", 55000);
        Employee employee5 = new Employee("E005", "Eve", "HR", 70000);

        // Add employees to the system
        ems.addEmployee(employee1);
        ems.addEmployee(employee2);
        ems.addEmployee(employee3);
        ems.addEmployee(employee4);
        ems.addEmployee(employee5);

        // Traverse and display all employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Search for an employee by ID
        String searchId = "E003";
        Employee foundEmployee = ems.searchEmployee(searchId);
        if (foundEmployee != null) {
            System.out.println("\nEmployee found:");
            System.out.println("ID: " + foundEmployee.employeeId + ", Name: " + foundEmployee.name +", Position: " + foundEmployee.position + ", Salary: " + foundEmployee.salary);
        } else {
            System.out.println("\nEmployee with ID " + searchId + " not found.");
        }

        // Delete an employee by ID
        String deleteId = "E002";
        ems.deleteEmployee(deleteId);
        System.out.println("\nEmployees after deleting employee with ID " + deleteId + ":");
        ems.traverseEmployees();
    }
}
