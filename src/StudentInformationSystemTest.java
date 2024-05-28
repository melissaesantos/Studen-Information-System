package test;
import org.junit.Before;
import org.junit.Test;

import InvalidStudentDataException;
import Student;
import StudentNotFoundException;
import StudentRecord;

import static org.junit.Assert.*;


public class StudentInformationSystemTest {
    private StudentRecord studentRecord;
    private Student student1;
    private Student student2;
    
    @Before
    public void setUp() {
        studentRecord = new StudentRecord();
        student1 = new Student("S001", "John Doe", 20, "Computer Science");
        student2 = new Student("S002", "Jane Smith", 22, "Mathematics");
    }

    @Test
    public void testAddStudent() throws InvalidStudentDataException, StudentNotFoundException {
        studentRecord.addStudent(student1);
        assertEquals(student1, studentRecord.getstudent("S001"));
    }


}