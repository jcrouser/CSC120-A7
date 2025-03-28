public class Course {

    // Attributes
    private String name;
    private String subjectNumber;
    private String meetingTime; 

    public Course(String name, String subjectNumber, String meetingTime) {
        this.name = name;
        this.subjectNumber = subjectNumber;
        this.meetingTime = meetingTime; 
    }

    public String getName() {
        return this.name;
    }

    public String getSubjectNumber() {
        return this.subjectNumber;
    }

    public String getMeetingTime() {
        return this.meetingTime;
    }

    public String toString() {
        return this.subjectNumber + ": " + this.name + " " + this.meetingTime; 
    }

    public static void main(String[] args) {
        Course csc120 = new Course("OOP", "CSC120", "TR 10:50");
        System.out.println(csc120);
    }
    
}
