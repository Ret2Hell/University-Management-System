import java.util.ArrayList;
import java.util.List;

class Club {
    private String clubName;
    private List<Student> members;

    public Club(String clubName) {
        this.clubName = clubName;
        this.members = new ArrayList<>();
    }

    public void addMember(Student student) {
        members.add(student);
    }

    public String getClubName() {
        return clubName;
    }

    public void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members in the club.");
            return;
        }
        System.out.println("Members of " + clubName + ":");
        for (Student member : members) {
            System.out.println(member.getName());
        }
    }
    public boolean isMember(Student student) {
        return members.contains(student);
    }
}
