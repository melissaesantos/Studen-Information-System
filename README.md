# Student Information System
## Description
The Student Information System is a Java application designed to manage student records efficiently. It provides functionalities for adding, removing, viewing, and updating student information. This project demonstrates object-oriented programming principles such as encapsulation and exception handling.

## Features
Create and manage student records.
Add, remove, view, and update student information.
Handle exceptions for invalid student data and when a student is not found in the records.
Usage
The StudentInformationSystem class serves as the entry point to the application. It allows users to interact with the system through a menu-driven interface. Users can perform operations such as adding a new student, removing an existing student, viewing student details, and updating student information.

## Project Structure
* Student.java: Defines the Student class, representing individual student information.
* StudentRecord.java: Implements the StudentRecord class, responsible for managing student records.
* StudentInformationSystem.java: Contains the main class to run the application and interact with users.
* InvalidStudentDataException.java: Defines the InvalidStudentDataException class, a custom exception thrown when invalid student data is encountered.
* StudentNotFoundException.java: Defines the StudentNotFoundException class, a custom exception thrown when a student is not found in the records.
* StudentInformationSystemTest.java: Provides unit tests for the StudentRecord class to ensure its methods behave as expected.
## Classes and Methods
### Student
* Student(String studentId, String name, int age, String major): Constructor to initialize student information.
* Getters and setters for all fields.
* toString(): Returns a string representation of the student.
#### StudentRecord
* void addStudent(Student student) throws InvalidStudentDataException: Adds a new student to the records.
* void removeStudent(String studentId) throws StudentNotFoundException: Removes a student from the records.
* Student getStudent(String studentId) throws StudentNotFoundException: Retrieves a student by ID.
* List<Student> getAllStudents(): Returns a list of all students in the records.
* void updateStudent(String studentId, Student updatedStudent) throws StudentNotFoundException, InvalidStudentDataException: Updates student information.
#### StudentInformationSystem
* void displayMenu(): Displays the menu options for users.
* void handleUserInput(): Handles user input to execute selected operations.
* void executeOption(int option): Executes the selected menu option.
* void addStudent(): Adds a new student to the records.
* void removeStudent(): Removes a student from the records.
* void viewStudent(): Displays details of a specific student.
* void viewAllStudents(): Displays details of all students in the records.
* void updateStudent(): Updates information for an existing student.
* public static void main(String[] args): Entry point to the application.
#### Custom Exceptions
* InvalidStudentDataException
* InvalidStudentDataException(String message): Constructor to initialize the exception with a custom message.
* StudentNotFoundException
* StudentNotFoundException(String message): Constructor to initialize the exception with a custom message.
