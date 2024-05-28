import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import java.util.InputMismatchException;
public class StudentInformationSystem {
    private Scanner scanner = new Scanner(System.in);
    private StudentRecord studentRecord = new StudentRecord();
    private int choice;
    
    public static void main(String[] args) throws InputMismatchException, InvalidStudentDataException, StudentNotFoundException {
        StudentInformationSystem system = new StudentInformationSystem();
        system.run();


    }
    public void run() throws InputMismatchException, InvalidStudentDataException, StudentNotFoundException{
        boolean running = true;
        while(running){
            displayMenu();
            int option = handleUserInput();
            running = executeOption(option);
        }
    }

    private void displayMenu() {
        System.out.println("Student Information System");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. View Student");
        System.out.println("4. View All Students");
        System.out.println("5. Update Student");
        System.out.println("6. Exit.");
        System.out.println("Choose an option: ");
    }

    public int handleUserInput(){
        int option = -1;
        boolean valid = false;
        try{
            option = scanner.nextInt();
            valid = true;
        }catch(InputMismatchException e ){
            System.out.println("Invalid input. Please enter the number of your choice.");
            scanner.next();// this clears the invalid input
        }

        return option;
    }

    public boolean executeOption(int option) throws InputMismatchException, InvalidStudentDataException, StudentNotFoundException{
        switch(option){
        
            case 1: //add student
                addStudent();
                break;
            case 2://remove student
                removeStudent();
                break;
            case 3://view student
                viewStudent();
                break;
            case 4:// view all students
                studentRecord.getAllStudents();
                break;
                
            case 5://update student
                updateStudent();
                break;
                
            case 6://exit
                System.out.println("Exiting.....");
                return false;
        }
        return true;
    }
    private void addStudent() throws InvalidStudentDataException,InputMismatchException{
        try{
             scanner.nextLine();//necessary to consume newline lefto over from nextInt
             System.out.println("Enter Student ID: ");
             String studenId = scanner.nextLine();//did next line to ensure that it is a string
             
             System.out.println("Enter Student name: ");
             String name = scanner.nextLine();
             
             System.out.println("Enter Student age: ");
             int age = scanner.nextInt();//next int ensures it is an integer
             scanner.nextLine();//necessary to consume newline lefto over from nextInt s s

             System.out.println("Enter Student Major: ");
             String major = scanner.nextLine();//next int ensures it is an integer
                //create the student
             Student student = new Student(studenId, name, age, major);
             //add student to the record
             studentRecord.addStudent(student);
             System.out.println("************Student added successfuly.************");

        }catch(InputMismatchException e){
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();
        }catch(InvalidStudentDataException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    private void removeStudent() throws InputMismatchException,StudentNotFoundException{
        try{
            scanner.nextLine();//necessary to consume newline lefto over from nextInt
            System.out.println("Enter Student ID: ");
            String studenId = scanner.nextLine();//did next line to ensure that it is a string
            
            //now remove the student: note it can throw a student not found error
            studentRecord.removeStudent(studenId);
            System.out.println("************Student removed successfuly.************");
        }catch(InputMismatchException e){
            System.out.println("Invalid input. Please try again.");
        }catch(StudentNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }

    private void viewStudent() throws InputMismatchException,StudentNotFoundException{
        try{
            scanner.nextLine();//necessary to consume newline lefto over from nextInt
            System.out.println("Enter Student ID: ");
            String studenId = scanner.nextLine();//did next line to ensure that it is a string
            
            //now remove the student: note it can throw a student not found error
            studentRecord.getstudent(studenId);
        }catch(InputMismatchException  e){
            System.out.println("Invalid input. Please try again.");
        }catch(StudentNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateStudent() throws InputMismatchException,StudentNotFoundException, InvalidStudentDataException{
        try{

            scanner.nextLine();//necessary to consume newline lefto over from nextInt
            System.out.println("Enter Student ID to update: ");
            String studenId = scanner.nextLine();//did next line to ensure that it is a string
            
            System.out.println(" Enter New student name: ");
            String name = scanner.nextLine();

            System.out.println(" Enter New student age: ");
            int age = scanner.nextInt();
            System.out.print("Enter New Student Major: ");
            scanner.nextLine();//necessary to consume newline lefto over from nextInt
            String major = scanner.nextLine();

            if (age <= 0) {
                throw new InvalidStudentDataException("Age must be a positive number.");
            }

            Student updatedStudent = new Student(studenId, name, age, major);
            studentRecord.updateStudent(studenId, updatedStudent);
           
            
        }catch(InputMismatchException  e){
            System.out.println("Invalid input. Please try again.");
        }catch(StudentNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
    }


}
