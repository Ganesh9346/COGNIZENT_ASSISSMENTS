/*

EXERCISE 5: TASK MANAGEMENT SYSTEM
1. Types of Linked Lists
Singly Linked List:
In a singly linked list, each node contains data and a reference to the next node. Traversal is 
possible only in the forward direction.

Doubly Linked List:
In a doubly linked list, each node contains data, a reference to the next node, and a reference to 
the previous node. Traversal can be done in both forward and backward directions.

2. Time Complexity Analysis
Add Task : O(n)
Search Task : O(n)
Traverse Tasks : O(n)
Delete Task : O(n)

3. Advantages of Linked Lists Over Arrays
• Linked lists can grow and shrink dynamically.
• Memory is allocated only when needed.
• Insertion and deletion operations are easier because elements do not need to be shifted.
• Linked lists are suitable when the number of records changes frequently.
*/

class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class Exercise5_TaskManagement {

    static Task head = null;

    // Add Task
    static void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }

        System.out.println("Task Added.");
    }

    // Search Task
    static void searchTask(int id) {
        Task temp = head;

        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Task Found");
                System.out.println("Task ID : " + temp.taskId);
                System.out.println("Task Name : " + temp.taskName);
                System.out.println("Status : " + temp.status);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found.");
    }

    // Traverse Tasks
    static void traverseTasks() {
        if (head == null) {
            System.out.println("No Tasks Available.");
            return;
        }

        Task temp = head;

        while (temp != null) {
            System.out.println("Task ID : " + temp.taskId);
            System.out.println("Task Name : " + temp.taskName);
            System.out.println("Status : " + temp.status);
            System.out.println();

            temp = temp.next;
        }
    }

    // Delete Task
    static void deleteTask(int id) {

        if (head == null) {
            System.out.println("List is Empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted.");
            return;
        }

        Task temp = head;

        while (temp.next != null &&
               temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task Not Found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task Deleted.");
        }
    }

    public static void main(String[] args) {

        addTask(101, "Prepare Report", "Pending");
        addTask(102, "Send Email", "Completed");
        addTask(103, "Attend Meeting", "Pending");

        System.out.println("\nAll Tasks");
        traverseTasks();

        System.out.println("Searching Task");
        searchTask(102);

        deleteTask(102);

        System.out.println("\nTasks After Deletion");
        traverseTasks();
    }
}