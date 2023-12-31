class Course {
    private String courseId;
    private Subject subject;
    private Teacher teacher;

    public Course(String courseId,Subject subject,Teacher teacher) {
        this.courseId=courseId;
        this.subject=subject;
        this.teacher=teacher;
    }

    public String getCourseId() {
        return courseId;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}