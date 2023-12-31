class Subject {
    private String subjectId;
    private String subjectName;

    public Subject(String subjectId,String subjectName) {
        this.subjectId=subjectId;
        this.subjectName=subjectName;
    }

    public String getSubjectCode() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }
}