import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import java.util.InputMismatchException;
public class StudentInformationSystem {
    private Scanner scanner = new Scanner(System.in);
    private StudentRecord studentRecord = new StudentRecord();
    private int choice;
    
    public static void main(String[] args) throws InputMismatchException, InvalidStudentDataException {
        StudentInformationSystem system = new StudentInformationSystem();
        system.run();


    }
    public void run() throws InputMismatchException, InvalidStudentDataException{
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
            case 4:// view all students
            case 5://update student
            case 6://exit
                System.out.println("Exiting.....");
                return false;
        }
        return true;
    }
    private void addStudent() throws InvalidStudentDataException,InputMismatchException{
        try{
             System.out.println("Enter Student ID: \n");
             String studenId = scanner.nextLine();//did next line to ensure that it is a string
             
             System.out.println("Enter Student name: \n");
             String name = scanner.nextLine();
             
             System.out.println("Enter Student age: \n");
             int age = scanner.nextInt();//next int ensures it is an integer

             System.out.println("Enter Student Major: \n");
             String major = scanner.nextLine();//next int ensures it is an integer
                //create the student
             Student student = new Student(studenId, name, age, major);
             //add student to the record
             studentRecord.addStudent(student);
             System.out.println("Student added successfuly.");

        }catch(InputMismatchException e){
            System.out.println("Invalid input. Please try again.");
            scanner.next();
        }catch(InvalidStudentDataException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    private void removeStudent() throws InputMismatchException,StudentNotFoundException{
        try{
            System.out.println("Enter Student ID: \n");
            String studenId = scanner.nextLine();//did next line to ensure that it is a string
            
            //now remove the student: note it can throw a student not found error
            studentRecord.removeStudent(studenId);
        }catch(InputMismatchException e){
            System.out.println("Invalid input. Please try again.");
        }catch(StudentNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }

}
