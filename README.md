
![GitHub repo size](https://img.shields.io/github/repo-size/nataliadiotto/ADA-Task?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/nataliadiotto/ADA-Task?style=for-the-badge)
![GitHub forks](https://img.shields.io/github/forks/nataliadiotto/ADA-Task?style=for-the-badge)
![Bitbucket open issues](https://img.shields.io/bitbucket/issues/nataliadiotto/ADA-Task?style=for-the-badge)
![Bitbucket open pull requests](https://img.shields.io/bitbucket/pr-raw/nataliadiotto/ADA-Task?style=for-the-badge)

**Ada Task**

Ada Task is a console-based task management application for personal, study, and work tasks. It provides functionalities for task creation, editing, deletion, and listing, with a focus on simplicity and ease of use.

Adjustments and Improvements
The project is still under development, and the next updates will focus on the following tasks:

 Implementation of basic CRUD functionalities
 Integration with data persistence
 Creation of unit test classes
 Implementation of user authentication
 User interface improvements

**💻 Prerequisites**

Before you begin, ensure you have met the following requirements:

You have installed the latest version of the Java Development Kit (JDK).
You have a Windows, Linux, or macOS machine.
You have read the documentation related to the project.

**Application Flow**

1. Task Creation
Users can create various types of tasks, such as Personal, Work, or Study tasks, each with its own specific attributes. The application ensures that task titles are unique and validates deadlines to be in the correct format and a future date.

java
Copy code
// Example of creating a Personal Task
BaseTask personalTask = new PersonalTask("Clean bedroom",
        "I need to clean my bedroom",
        TaskType.PERSONAL,
        "04/05/2024",
        Priority.LOW,
        CurrentStatus.PENDING,
        "house chores");
taskService.saveTask(personalTask);
2. Displaying Tasks
Users can view all tasks, providing an overview of their pending tasks. This functionality is available through the displayTasks method in the TaskController.

java
Copy code
// Example of displaying all tasks
taskService.findAll();
3. Task Update
Users can update existing tasks, modifying attributes like title, description, deadline, priority, and status.

java
Copy code
// Example of updating a Personal Task
taskController.updateTask(1, personalTask);
4. Task Deletion
Users have the ability to delete tasks based on their unique identifiers.

java
Copy code
// Example of deleting a task by ID
taskController.deleteTask(1);
5. Task Persistence
The application stores tasks using the TaskRepositoryImpl, which provides basic CRUD operations for task management. Tasks are stored in-memory during the application's runtime.

6. Application Initialization
The Main class serves as the entry point for the application. It initializes a sample set of tasks using the populateList method and provides a simple user interface for interacting with the task management system.

java
Copy code
// Example of initializing the application
public static void main(String[] args) {
    TaskRepositoryImpl<BaseTask, Integer> taskRepository = new TaskRepositoryImpl<>();
    TaskService<BaseTask, Integer> taskService = new TaskService<>(taskRepository);
    TaskController taskController = new PersonalTaskController<>(taskService);

    populateList(taskService);  // Initialize with sample tasks
    taskController.displayTasks();  // Display all tasks

    // Additional user interactions can be added here
}
Getting Started

Clone the repository to your local machine.
bash
Copy code
git clone <repository_url>
Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
Run the Main class to start the application.
Follow the on-screen instructions to interact with the Personal Task Manager.
Enjoy organizing your tasks with the Personal Task Manager!


📫 Contributing to Ada Task

To contribute to Ada Task, follow these steps:

1. Fork this repository.
2. Create a branch: `git checkout -b <nome_branch>`.
3. Make your changes and commit them: `git commit -m '<mensagem_commit>'`
4. Push to the original branch: `git push origin <nome_do_projeto> / <local>`
5. Create the pull request.

Alternatively, see the GitHub documentation on how to create a pull request.

😄 Become a Contributor

Want to contribute to this project? Click HERE and read how to contribute.

📝 License

This project is licensed under the LICENSE.
