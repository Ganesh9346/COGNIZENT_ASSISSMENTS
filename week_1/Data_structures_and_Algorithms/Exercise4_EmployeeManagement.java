/* 

EXERCISE 4: EMPLOYEE MANAGEMENT SYSTEM
1. Array Representation
An array stores elements in contiguous memory locations. Each element is stored one after another, 
and every element can be accessed using its index value.

2. Advantages of Arrays
• Arrays provide fast access to elements using indexes.
• They are easy to implement and understand.
• Arrays require less memory overhead because no extra pointers are needed.

3. Time Complexity Analysis
Add Employee : O(1)
Search Employee : O(n)
Traverse Employees : O(n)
Delete Employee : O(n)

4. Limitations of Arrays
• Arrays have a fixed size and cannot grow dynamically.
• Insertion and deletion operations are costly because elements need to be shifted.
• Memory may be wasted if the array size is larger than the actual number of elements.

5. When to Use Arrays
Arrays are suitable when the number of records is known in advance and frequent insertions or 
deletions are not required.
*/

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name,
             String position, double salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID : " + employeeId);
        System.out.println("Name : " + name);
        System.out.println("Position : " + position);
        System.out.println("Salary : " + salary);
        System.out.println();
    }
}

public class Exercise4_EmployeeManagement {

    static Employee[] employees = new Employee[10];
    static int count = 0;

    // Add Employee
    static void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count] = e;
            count++;
            System.out.println("Employee Added.");
        } else {
            System.out.println("Array is Full.");
        }
    }

    // Search Employee
    static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee Found");
                employees[i].display();
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    // Traverse Employees
    static void traverseEmployees() {
        if (count == 0) {
            System.out.println("No Employees Present.");
            return;
        }

        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Delete Employee
    static void deleteEmployee(int id) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee Not Found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee Deleted.");
    }

    public static void main(String[] args) {

        addEmployee(new Employee(
                101, "Rahul", "Manager", 50000));

        addEmployee(new Employee(
                102, "Priya", "Developer", 40000));

        addEmployee(new Employee(
                103, "Kiran", "Tester", 35000));

        System.out.println("\nEmployee Records");
        traverseEmployees();

        System.out.println("Searching Employee");
        searchEmployee(102);

        deleteEmployee(102);

        System.out.println("\nEmployee Records After Deletion");
        traverseEmployees();
    }
}