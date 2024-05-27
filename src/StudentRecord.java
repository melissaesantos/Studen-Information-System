import java.util.HashMap;
import java.util.Map;

public class StudentRecord{
   private Map<String, Student> students = new HashMap<>();

   public void addStudent(Student student){
        if( student == null||student.getName() == null || student.getstudentID() == null || student.getAge()<=0|| student.getMajor() == null ){
            throw new InvalidStudentDataException("Invalid student data.")
        }
        students.put(student.getstudentID(),student);
   }
}
