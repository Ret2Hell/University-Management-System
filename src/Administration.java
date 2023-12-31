import java.util.List;
import java.util.ArrayList;
class Administration {
    private List<Teacher> teachers;
    private List<Student> students;

    public Administration() {
        teachers=new ArrayList<>();
        students=new ArrayList<>();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachers);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

}