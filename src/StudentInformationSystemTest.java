import org.junit.Before;
import org.junit.Test;
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
    @Test(expected = InvalidStudentDataException.class)
    public void testAddStudentWithInvalidData() throws InvalidStudentDataException {
        Student invalidStudent = new Student("S003", "Invalid Student", -5, "Physics");
        studentRecord.addStudent(invalidStudent);
    }

    @Test
    public void testRemoveStudent() throws StudentNotFoundException, InvalidStudentDataException {
        studentRecord.addStudent(student1);
        studentRecord.removeStudent("S001");
        assertNull(studentRecord.getstudent("S001"));
    }

    @Test(expected = StudentNotFoundException.class)
    public void testRemoveNonExistentStudent() throws StudentNotFoundException {
        studentRecord.removeStudent("S999");
    }

    @Test
    public void testViewStudent() throws InvalidStudentDataException, StudentNotFoundException {
        studentRecord.addStudent(student1);
        assertEquals(student1, studentRecord.getstudent("S001"));
    }

    @Test
    public void testViewAllStudents() throws InvalidStudentDataException {
        studentRecord.addStudent(student1);
        studentRecord.addStudent(student2);
        assertEquals(2, studentRecord.getAllStudents().size());
    }

    @Test
    public void testUpdateStudent() throws StudentNotFoundException, InvalidStudentDataException {
        studentRecord.addStudent(student1);
        Student updatedStudent = new Student("S001", "John Doe", 21, "Computer Engineering");
        studentRecord.updateStudent("S001", updatedStudent);
        assertEquals(updatedStudent, studentRecord.getstudent("S001"));
    }

    @Test(expected = StudentNotFoundException.class)
    public void testUpdateNonExistentStudent() throws StudentNotFoundException, InvalidStudentDataException {
        Student updatedStudent = new Student("S999", "Non Existent", 21, "Unknown");
        studentRecord.updateStudent("S999", updatedStudent);
    }
}

