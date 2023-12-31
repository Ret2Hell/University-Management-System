class Classroom {
    private String classroomId;
    private int capacity;

    public Classroom(String classroomId,int capacity) {
        this.classroomId=classroomId;
        this.capacity=capacity;

    }

    public String getClassroomId() {
        return classroomId;
    }

    public int getCapacity() {
        return capacity;
    }

}