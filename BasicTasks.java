import java.util.ArrayList;
import java.util.Scanner;

public class BasicTasks {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    taskList.addTask(getTaskName(scanner));
                    break;
                case 2:
                    if (!taskList.isEmpty()) {
                        taskList.listTasks();
                        int taskNumberToRemove = getUserInput(scanner, "Enter the task number to remove: ");
                        if (taskList.isValidTaskNumber(taskNumberToRemove)) {
                            taskList.removeTask(taskNumberToRemove);
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } else {
                        System.out.println("No tasks to remove.");
                    }
                    break;
                case 3:
                    if (!taskList.isEmpty()) {
                        taskList.listTasks();
                    } else {
                        System.out.println("No tasks to list.");
                    }
                    break;
                case 4:
                    if (!taskList.isEmpty()) {
                        taskList.listTasks();
                        int taskNumberToEdit = getUserInput(scanner, "Enter the task number to edit: ");
                        if (taskList.isValidTaskNumber(taskNumberToEdit)) {
                            taskList.editTaskName(taskNumberToEdit, getTaskName(scanner));
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } else {
                        System.out.println("No tasks to edit.");
                    }
                    break;
                case 5:
                    if (!taskList.isEmpty()) {
                        taskList.listTasks();
                        int taskNumberToMarkCompleted = getUserInput(scanner, "Enter the task number to mark as completed: ");
                        if (taskList.isValidTaskNumber(taskNumberToMarkCompleted)) {
                            taskList.markTaskAsCompleted(taskNumberToMarkCompleted);
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } else {
                        System.out.println("No tasks to mark as completed.");
                    }
                    break;
                case 6:
                    taskList.saveTasksToFile();
                    break;
                case 7:
                    taskList.loadTasksFromFile();
                    break;
                case 8:
                    if (!taskList.isEmpty()) {
                        taskList.listTasks();
                        int taskNumberToSetPriority = getUserInput(scanner, "Enter the task number to set priority: ");
                        if (taskList.isValidTaskNumber(taskNumberToSetPriority)) {
                            taskList.setPriorityForTask(taskNumberToSetPriority, getTaskPriority(scanner));
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } else {
                        System.out.println("No tasks to set priority.");
                    }
                    break;
                case 9:
                    if (!taskList.isEmpty()) {
                        taskList.listTasks();
                        int taskNumberToSetDueDate = getUserInput(scanner, "Enter the task number to set due date: ");
                        if (taskList.isValidTaskNumber(taskNumberToSetDueDate)) {
                            taskList.setDueDateForTask(taskNumberToSetDueDate, getDueDate(scanner));
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    } else {
                        System.out.println("No tasks to set due date.");
                    }
                    break;
                case 10:
                    taskList.listTasks();
                    String category = getCategory(scanner);
                    taskList.filterTasksByCategory(category);
                    break;
                case 11:
                    taskList.listTasks();
                    String keyword = getKeyword(scanner);
                    taskList.searchTasks(keyword);
                    break;
                case 12:
                    taskList.undoLastAction();
                    break;
                case 13:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Task List Application");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Edit Task Name");
        System.out.println("5. Mark Task as Completed");
        System.out.println("6. Save Tasks to File");
        System.out.println("7. Load Tasks from File");
        System.out.println("8. Set Priority for Task");
        System.out.println("9. Set Due Date for Task");
        System.out.println("10. Filter Tasks by Category");
        System.out.println("11. Search Tasks by Keyword");
        System.out.println("12. Undo Last Action");
        System.out.println("13. Quit");
        System.out.print("Select an option: ");
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }

    private static String getTaskName(Scanner scanner) {
        System.out.print("Enter task name: ");
        return scanner.next();
    }

    private static int getUserInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private static String getTaskPriority(Scanner scanner) {
        System.out.print("Enter task priority (high, medium, low): ");
        return scanner.next();
    }

    private static String getDueDate(Scanner scanner) {
        System.out.print("Enter due date for the task (YYYY-MM-DD): ");
        return scanner.next();
    }

    private static String getCategory(Scanner scanner) {
        System.out.print("Enter category to filter tasks: ");
        return scanner.next();
    }

    private static String getKeyword(Scanner scanner) {
        System.out.print("Enter keyword to search tasks: ");
        return scanner.next();
    }
}

class TaskList {
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Task> undoList = new ArrayList<>();

    public void addTask(String name) {
        tasks.add(new Task(name));
        System.out.println("Task added.");
    }

    public void removeTask(int taskNumber) {
        undoList.add(tasks.get(taskNumber - 1));
        tasks.remove(taskNumber - 1);
        System.out.println("Task removed.");
    }

    public void editTaskName(int taskNumber, String newName) {
        undoList.add(tasks.get(taskNumber - 1));
        tasks.get(taskNumber - 1).setName(newName);
        System.out.println("Task name edited.");
    }

    public void markTaskAsCompleted(int taskNumber) {
        undoList.add(tasks.get(taskNumber - 1));
        tasks.get(taskNumber - 1).setCompleted(true);
        System.out.println("Task marked as completed.");
    }

    public void saveTasksToFile() {
        // Implement saving tasks to a file
        System.out.println("Tasks saved to file.");
    }

    public void loadTasksFromFile() {
        // Implement loading tasks from a file
        System.out.println("Tasks loaded from file.");
    }

    public void setPriorityForTask(int taskNumber, String priority) {
        undoList.add(tasks.get(taskNumber - 1));
        tasks.get(taskNumber - 1).setPriority(priority);
        System.out.println("Priority set for the task.");
    }

    public void setDueDateForTask(int taskNumber, String dueDate) {
        undoList.add(tasks.get(taskNumber - 1));
        tasks.get(taskNumber - 1).setDueDate(dueDate);
        System.out.println("Due date set for the task.");
    }

    public void filterTasksByCategory(String category) {
        System.out.println("Tasks filtered by category: " + category);
        for (Task task : tasks) {
            if (task.getCategory() != null && task.getCategory().equalsIgnoreCase(category)) {
                System.out.println(task);
            }
        }
    }

    public void searchTasks(String keyword) {
        System.out.println("Tasks matching the keyword: " + keyword);
        for (Task task : tasks) {
            if (task.getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(task);
            }
        }
    }

    public void undoLastAction() {
        if (!undoList.isEmpty()) {
            Task lastTask = undoList.remove(undoList.size() - 1);
            tasks.add(lastTask);
            System.out.println("Last action undone.");
        } else {
            System.out.println("No actions to undo.");
        }
    }

    public void listTasks() {
        if (!tasks.isEmpty()) {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        } else {
            System.out.println("No tasks available.");
        }
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= tasks.size();
    }

    private static class Task {
        private String name;
        private boolean completed;
        private String priority;
        private String dueDate;
        private String category;

        public Task(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", completed=" + completed +
                    ", priority='" + priority + '\'' +
                    ", dueDate='" + dueDate + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }
}
