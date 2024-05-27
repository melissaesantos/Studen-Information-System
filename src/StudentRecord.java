import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class StudentRecord{
   private Map<String, Student> students = new HashMap<>();

   public void addStudent(Student student) throws InvalidStudentDataException{
        if( student == null||student.getName() == null || student.getstudentID() == null || student.getAge()<=0|| student.getMajor() == null ){
            throw new InvalidStudentDataException("Invalid student data.");
        }
        students.put(student.getstudentID(),student);
   }

   public void removeStudent(String studentID) throws StudentNotFoundException{
        if (students.containsKey(studentID) == false){
            throw new StudentNotFoundException("Student record does not exist.");
        }
        students.remove(studentID);
   }
   public Student getstudent(String studentID) throws StudentNotFoundException{
        if(!students.containsKey(studentID)){
            throw new StudentNotFoundException("Student not found.");
        }
        return students.get(studentID);
   }
   public List<Student> getAllStudents(){
        return new ArrayList<>(students.values());

   }
}
