class Task {
    String taskId;
    String taskName;
    String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
}

class SinglyLinkedList {
    private class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public Task searchTask(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.taskId.equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.task.taskId + ", Name: " + temp.task.taskName + ", Status: " + temp.task.status);
            temp = temp.next;
        }
    }

    public void deleteTask(String taskId) {
        if (head == null) return;

        if (head.task.taskId.equals(taskId)) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && !temp.next.task.taskId.equals(taskId)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Initialize the singly linked list
        SinglyLinkedList taskList = new SinglyLinkedList();

        // Create some task objects
        Task task1 = new Task("T001", "Design", "Pending");
        Task task2 = new Task("T002", "Development", "In Progress");
        Task task3 = new Task("T003", "Testing", "Not Started");
        Task task4 = new Task("T004", "Deployment", "Completed");
        Task task5 = new Task("T005", "Documentation", "In Progress");

        // Add tasks to the list
        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        taskList.addTask(task4);
        taskList.addTask(task5);

        // Traverse and display all tasks
        System.out.println("All Tasks:");
        taskList.traverseTasks();

        // Search for a task by ID
        String searchId = "T003";
        Task foundTask = taskList.searchTask(searchId);
        if (foundTask != null) {
            System.out.println("\nTask found:");
            System.out.println("ID: " + foundTask.taskId + ", Name: " + foundTask.taskName + 
                               ", Status: " + foundTask.status);
        } else {
            System.out.println("\nTask with ID " + searchId + " not found.");
        }

        // Delete a task by ID
        String deleteId = "T002";
        taskList.deleteTask(deleteId);
        System.out.println("\nTasks after deleting task with ID " + deleteId + ":");
        taskList.traverseTasks();
    }
}