public class Student{
    private String studentID;
    private String name;
    private int age;
    private String major;

    Student(String studentID, String name, int age, String major){
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.major = major;
    }
    //getter and setters
    public String getstudentID(){
        return studentID; 
    }

    public void setStudentID(){
        this.studentID = studentID;
    }

    public String getName(){
        return name; 
    }

    public void setName(){
        this.name = name;
    }
    public int getAge(){
        return age; 
    }

    public void setAge(){
        this.age = age;
    }

    public String getMajor(){
        return major; 
    }
    
    public void setMajor(){
        this.major = major;
    }

    @Override
    public  String toString(){
        return  "Student ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Major: " + major;
    }
}