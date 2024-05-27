"# Basic_TaskListApp-java-" 

# Task List Application

This Java application allows users to manage tasks efficiently. It provides features like adding, removing, listing, editing, marking as completed, setting priority and due date, filtering by category, searching by keyword, saving tasks to a file, loading tasks from a file, and undoing the last action.

## Usage

1. *Add Task*: Add a new task to the task list.
2. *Remove Task*: Remove a task from the task list by specifying its number.
3. *List Tasks*: Display all tasks in the task list.
4. *Edit Task Name*: Edit the name of a task by specifying its number.
5. *Mark Task as Completed*: Mark a task as completed by specifying its number.
6. *Save Tasks to File*: Save the current task list to a file.
7. *Load Tasks from File*: Load tasks from a file into the task list.
8. *Set Priority for Task*: Set priority (high, medium, low) for a task by specifying its number.
9. *Set Due Date for Task*: Set a due date for a task by specifying its number.
10. *Filter Tasks by Category*: Filter tasks by category.
11. *Search Tasks by Keyword*: Search tasks by keyword.
12. *Undo Last Action*: Undo the last performed action.
13. *Quit*: Exit the application.

## Running the Application

1. Ensure you have Java installed on your system. If not, download and install the Java Development Kit (JDK) from [here](https://www.oracle.com/java/technologies/javase-downloads.html).

2. Clone the repository:

    
    git clone  https://github.com/Ruthik005/Basic_TaskListApp-java-.git
    

3. Navigate to the project directory:

    
    cd task-list
    

4. Compile the project:

    
    javac BasicTasks.java
    

5. Run the application:

    
    java BasicTasks
    

## Dependencies

- Java Development Kit (JDK)

## Notes

- To run the application in Visual Studio Code, use the shortcut Ctrl+F5.

- ## Methods:
•	main(String[] args): Entry point of the application. Displays the menu and handles user input.

•	displayMenu(): Displays the menu options for the user.

•	getUserChoice(Scanner scanner): Reads and returns the user's menu choice.

•	getTaskName(Scanner scanner): Prompts the user to enter a task name and returns it.

•	getUserInput(Scanner scanner, String prompt): Prompts the user for input with the given message and returns the entered integer.

•	getTaskPriority(Scanner scanner): Prompts the user to enter a task priority and returns it.

•	getDueDate(Scanner scanner): Prompts the user to enter a due date for a task and returns it.

•	getCategory(Scanner scanner): Prompts the user to enter a category for filtering tasks and returns it.

•	getKeyword(Scanner scanner): Prompts the user to enter a keyword for searching tasks and returns it.


TaskList

The TaskList class represents the task list itself. It manages tasks and provides various methods for manipulating them. Each task has a name, completion status, priority, due date, and category.

Methods:

•	addTask(String name): Adds a new task with the given name to the task list.

•	removeTask(int taskNumber): Removes the task at the specified index from the task list.

•	editTaskName(int taskNumber, String newName): Modifies the name of the task at the specified index.

•	markTaskAsCompleted(int taskNumber): Marks the task at the specified index as completed.

•	saveTasksToFile(): Saves the current task list to a file.

•	loadTasksFromFile(): Loads tasks from a file into the task list.

•	setPriorityForTask(int taskNumber, String priority): Sets the priority for the task at the specified index.

•	setDueDateForTask(int taskNumber, String dueDate): Sets the due date for the task at the specified index.

•	filterTasksByCategory(String category): Filters tasks based on the specified category.

•	searchTasks(String keyword): Searches for tasks containing the specified keyword in their names.

•	undoLastAction(): Undoes the last action performed by restoring the task list to its previous state.

•	listTasks(): Lists all tasks currently in the task list.

•	isEmpty(): Checks if the task list is empty.

•	isValidTaskNumber(int taskNumber): Checks if the specified task number is valid (within the range of available tasks).

Design Choices:

•	The application utilizes a console-based user interface for simplicity and ease of use.

•	Tasks are represented as objects of the inner Task class within the TaskList class. This encapsulates task-related data and behavior.

•	Separate methods are provided for each operation to ensure modularity and maintainability.

•	Input validation is implemented to handle invalid user input gracefully and provide a smooth user experience.

Challenges Faced:

•	Managing the undo functionality required careful tracking of the previous state of the task list to facilitate reverting changes.

•	Implementing file I/O operations for saving and loading tasks involved dealing with file handling and exceptions.

•	Ensuring robust input validation to handle various edge cases and prevent runtime errors posed a challenge.

Overall, the task list application provides a comprehensive set of features for managing tasks effectively, with a focus on simplicity and usability.

