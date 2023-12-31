class Exam {
    private String examId;
    private Course course;
    private String date;
    private int durationMinutes;
    private Classroom classroom;

    public Exam(String examId,Course course,String date,int durationMinutes,Classroom classroom) {
        this.examId=examId;
        this.course=course;
        this.date=date;
        this.durationMinutes=durationMinutes;
        this.classroom=classroom;
    }

    public String getExamId() {
        return examId;
    }

    public Course getCourse() {
        return course;
    }

    public String getDate() {
        return date;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public Classroom getClassroom() {
        return classroom;
    }
}