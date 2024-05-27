import java.util.Scanner;
import java.util.InputMismatchException;
public class StudentInformationSystem {
    private Scanner scanner = new Scanner(System.in);
    private StudentRecord studentRecord = new StudentRecord();
    private int choice;
    
    public static void main(String[] args) {
        StudentInformationSystem system = new StudentInformationSystem();
        system.run();


    }
    public void run(){
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

    public boolean executeOption(int option){
        switch(option){
            case 1: //add student
            case 2://remove student
            case 3://view student
            case 4:// view all students
            case 5://update student
            case 6://exit
                System.out.println("Exiting.....");
                return false;
        }
        return true;
    }
}
