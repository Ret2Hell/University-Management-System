import java.util.ArrayList;
import java.util.List;
class Student extends Person {
    private String studentId;

    public Student(String name,int age,String studentId) {
        super(name,age);
        this.studentId=studentId;
    }
    public String getStudentId() {
        return studentId;
    }


}