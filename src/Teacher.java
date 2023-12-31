import java.util.ArrayList;
import java.util.List;
class Teacher extends Person {
    private String teacherId;


    public Teacher(String name,int age,String teacherId) {
        super(name,age);
        this.teacherId=teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }


}