import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class Main {
    private static Scanner scanner=new Scanner(System.in);
    private static Administration admin=new Administration();
    private static List<Course> courses=new ArrayList<>();
    private static List<Classroom> classrooms=new ArrayList<>();
    private static List<Exam> exams=new ArrayList<>();
    private static List<Subject> subjects=new ArrayList<>();
    private static List<Club> clubs=new ArrayList<>();

    public static void main(String[] args) {
        boolean exit=false;

        while (!exit) {
            System.out.println("\n======University Management System======");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Teacher");
            System.out.println("4. View All Teachers");
            System.out.println("5. Add Subject");
            System.out.println("6. View All Subject");
            System.out.println("7. Add Classroom");
            System.out.println("8. View All Classrooms");
            System.out.println("9. Add Course");
            System.out.println("10. View All Courses");
            System.out.println("11. Add Exam");
            System.out.println("12. View All Exams");
            System.out.println("13. Add Club");
            System.out.println("14. View All Clubs");
            System.out.println("15. Add Student to Club");
            System.out.println("16. Exit");
            System.out.print("Choose an option: ");

            int choice=scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    addTeacher();
                    break;
                case 4:
                    viewAllTeachers();
                    break;
                case 5:
                    addSubject();
                    break;
                case 6:
                    viewAllSubjects();
                    break;
                case 7:
                    addClassroom();
                    break;
                case 8:
                    viewAllClassrooms();
                    break;
                case 9:
                    addCourse();
                    break;
                case 10:
                    viewAllCourses();
                    break;

                case 11:
                    addExam();
                    break;
                case 12:
                    viewAllExams();
                    break;
                case 13:
                    addClub();
                    break;
                case 14:
                    viewAllClubs();
                    break;
                case 15:
                    addStudentToClub();
                    break;
                case 16:
                    exit=true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Exiting University Management System...");
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        String studentId=scanner.next();
        if (!isUniqueStudentId(studentId)) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name=scanner.next();
        System.out.print("Enter student age: ");
        int age;
        try {
            age=scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for age. Please enter a valid integer.");
            scanner.next();
            return;
        }


        Student student=new Student(name,age,studentId);
        admin.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private static void viewAllStudents() {
        List<Student> students=admin.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println("ID: " + student.getStudentId() + "\tName: " + student.getName() + "\tAge: " + student.getAge());
        }
    }
    private static void addTeacher() {
        System.out.print("Enter teacher ID: ");
        String teacherId=scanner.next();
        if (!isUniqueTeacherId(teacherId)) {
            System.out.println("Teacher ID already exists.");
            return;
        }

        System.out.print("Enter teacher name: ");
        String name=scanner.next();

        System.out.print("Enter teacher age: ");
        int age;
        try {
            age=scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for age. Please enter a valid integer.");
            scanner.next();
            return;
        }



        Teacher teacher=new Teacher(name,age,teacherId);
        admin.addTeacher(teacher);
        System.out.println("Teacher added successfully!");
    }

    private static void viewAllTeachers() {
        List<Teacher> teachers=admin.getAllTeachers();
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }

        System.out.println("List of Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println("ID: " + teacher.getTeacherId() + "\tName: " + teacher.getName() + "\tAge: " + teacher.getAge());
        }
    }
    private static void addSubject() {
        System.out.print("Enter subject ID: ");
        String subjectId=scanner.next();
        if (!isUniqueSubjectId(subjectId)) {
            System.out.println("Subject ID already exists.");
            return;
        }

        System.out.print("Enter subject name: ");
        String subjectName=scanner.next();

        Subject subject=new Subject(subjectId,subjectName);
        subjects.add(subject);
        System.out.println("Subject added successfully!");
    }
    private static void viewAllSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects available.");
            return;
        }

        System.out.println("List of Subjects:");
        for (Subject subject : subjects) {
            System.out.println("ID: " + subject.getSubjectCode() + "\tName: " + subject.getSubjectName());
        }
    }
    private static void addCourse() {
        System.out.print("Enter course ID: ");
        String courseId=scanner.next();
        if (!isUniqueCourseId(courseId)) {
            System.out.println("Course ID already exists.");
            return;
        }

        Teacher selectedTeacher=selectTeacher();
        if (selectedTeacher==null) {
            System.out.println("No teachers available.");
            return;
        }

        Subject selectedSubject=selectSubject();
        if (selectedSubject==null) {
            System.out.println("No subjects available.");
            return;
        }

        Course course=new Course(courseId,selectedSubject,selectedTeacher);
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    private static void viewAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }

        System.out.println("List of Courses:");
        for (Course course : courses) {
            System.out.println("ID: " + course.getCourseId() + "\tSubject: " + course.getSubject().getSubjectName() + "\tTeacher: " + course.getTeacher().getName());
        }
    }

    private static Teacher selectTeacher() {
        List<Teacher> teachers=admin.getAllTeachers();
        if (teachers.isEmpty()) {
            return null;
        }

        System.out.println("Select a teacher (by ID):");
        viewAllTeachers();
        int choice=scanner.nextInt();
        return teachers.get(choice-1);
    }

    private static Subject selectSubject() {
        if (subjects.isEmpty()) {
            return null;
        }

        System.out.println("Select a subject (by ID):");
        viewAllSubjects();
        int choice = scanner.nextInt();
        return subjects.get(choice - 1);
    }

    private static void addClassroom() {
        System.out.print("Enter classroom ID: ");
        String classroomId=scanner.next();
        if (!isUniqueClassroomId(classroomId)) {
            System.out.println("Classroom ID already exists.");
            return;
        }

        System.out.print("Enter classroom capacity: ");
        int capacity;
        try {
            capacity=scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for capacity. Please enter a valid integer.");
            scanner.next();
            return;
        }

        Classroom classroom=new Classroom(classroomId,capacity);
        classrooms.add(classroom);
        System.out.println("Classroom added successfully!");
    }

    private static void viewAllClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms found.");
            return;
        }

        System.out.println("List of Classrooms:");
        for (Classroom classroom : classrooms) {
            System.out.println("ID: " + classroom.getClassroomId() + "\tCapacity: " + classroom.getCapacity());
        }
    }

    private static void addExam() {
        System.out.print("Enter exam ID: ");
        String examId=scanner.next();
        if (!isUniqueExamId(examId)) {
            System.out.println("Exam ID already exists.");
            return;
        }

        if (courses.isEmpty() || classrooms.isEmpty()) {
            System.out.println("Add courses and classrooms first.");
            return;
        }

        viewAllCourses();
        System.out.print("Enter the course ID for the exam: ");
        String courseId=scanner.next();
        Course selectedCourse=findCourseByCode(courseId);
        if (selectedCourse==null) {
            System.out.println("Course not found.");
            return;
        }

        viewAllClassrooms();
        System.out.print("Enter the classroom ID for the exam: ");
        String classroomId=scanner.next();
        Classroom selectedClassroom=findClassroomById(classroomId);
        if (selectedClassroom==null) {
            System.out.println("Classroom not found.");
            return;
        }

        System.out.print("Enter the exam date (e.g., 2023-12-31): ");
        String examDate=scanner.next();

        System.out.print("Enter the exam duration in minutes: ");
        int duration;
        try {
            duration = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for duration. Please enter a valid integer.");
            scanner.next();
            return;
        }

        Exam exam = new Exam(examId,selectedCourse,examDate,duration,selectedClassroom);
        exams.add(exam);
        System.out.println("Exam added successfully!");
    }
    private static Course findCourseByCode(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    private static Classroom findClassroomById(String classroomId) {
        for (Classroom classroom : classrooms) {
            if (classroom.getClassroomId().equals(classroomId)) {
                return classroom;
            }
        }
        return null;
    }

    private static void viewAllExams() {
        if (exams.isEmpty()) {
            System.out.println("No exams found.");
            return;
        }

        System.out.println("List of Exams:");
        for (Exam exam : exams) {
            System.out.println("ID: " + exam.getExamId() + "\tCourseCode: " + exam.getCourse().getCourseId() + "\tDate: " + exam.getDate() + "\tDuration: " + exam.getDurationMinutes() + "\tClassroom: " + exam.getClassroom().getClassroomId());
        }
    }
    private static void addClub() {
        System.out.print("Enter the name of the new club: ");
        String clubName=scanner.next();
        if (!isUniqueClubName(clubName)) {
            System.out.println("Club name already exists.");
            return;
        }

        Club newClub=new Club(clubName);
        clubs.add(newClub);
        System.out.println("Club added successfully!");
    }
    private static void viewAllClubs() {
        if (clubs.isEmpty()) {
            System.out.println("No clubs available.");
            return;
        }

        System.out.println("List of Clubs:");
        for (Club club : clubs) {
            System.out.println("Club: " + club.getClubName());
            club.viewMembers();
            System.out.println();
        }
    }
    private static void addStudentToClub() {
        List<Student> students=admin.getAllStudents();
        if (students.isEmpty() || clubs.isEmpty()) {
            System.out.println("No students or clubs available.");
            return;
        }

        System.out.println("List of Students:");
        viewAllStudents();
        System.out.print("Enter the ID of the student to add to a club: ");
        String studentId=scanner.next();

        Student selectedStudent=findStudentById(studentId);
        if (selectedStudent==null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("List of Clubs:");
        for (Club club : clubs) {
            System.out.println(club.getClubName());
        }
        System.out.print("Enter the name of the club to add the student to: ");
        String clubName=scanner.next();


        Club selectedClub=findClubByName(clubName);
        if (selectedClub==null) {
            System.out.println("Club not found.");
            return;
        }

        if (selectedClub.isMember(selectedStudent)) {
            System.out.println("Student is already a member of this club.");
            return;
        }

        selectedClub.addMember(selectedStudent);
        System.out.println("Student added to the club successfully!");
    }

    private static Student findStudentById(String studentId) {
        List<Student> students=admin.getAllStudents();
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    private static Club findClubByName(String clubName) {
        for (Club club : clubs) {
            if (club.getClubName().equals(clubName)) {
                return club;
            }
        }
        return null;
    }
    private static boolean isUniqueStudentId(String studentId) {
        return admin.getAllStudents().stream().noneMatch(s -> s.getStudentId().equals(studentId));
    }

    private static boolean isUniqueTeacherId(String teacherId) {
        return admin.getAllTeachers().stream().noneMatch(t -> t.getTeacherId().equals(teacherId));
    }

    private static boolean isUniqueSubjectId(String subjectId) {
        return subjects.stream().noneMatch(s -> s.getSubjectCode().equals(subjectId));
    }

    private static boolean isUniqueCourseId(String courseId) {
        return courses.stream().noneMatch(c -> c.getCourseId().equals(courseId));
    }

    private static boolean isUniqueExamId(String examId) {
        return exams.stream().noneMatch(e -> e.getExamId().equals(examId));
    }

    private static boolean isUniqueClubName(String clubName) {
        return clubs.stream().noneMatch(c -> c.getClubName().equals(clubName));
    }

    private static boolean isUniqueClassroomId(String classroomId) {
        return classrooms.stream().noneMatch(c -> c.getClassroomId().equals(classroomId));
    }

}