import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private ArrayList<String> enrolledStudents;

    private String scheduleDay;
    private String scheduleTimeSlot;


    public Course(String courseCode, String courseName, String scheduleDay, String scheduleTimeSlot) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.scheduleDay = scheduleDay;
        this.scheduleTimeSlot = scheduleTimeSlot;
        this.enrolledStudents = new ArrayList<>();
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setScheduleDay(String scheduleDay) {
        this.scheduleDay = scheduleDay;
    }

    public void setScheduleTimeSlot(String scheduleTimeSlot) {
        this.scheduleTimeSlot = scheduleTimeSlot;
    }

    public String getScheduleDay() {
        return scheduleDay;
    }
    
    public String getScheduleTimeSlot() {
        return scheduleTimeSlot;
    }

    public void addStudent(String studentID){
        if(!enrolledStudents.contains(studentID)){
            enrolledStudents.add(studentID);
            System.out.println("Enrolled student with ID: " + studentID + " in course: "+ courseCode);
        }else{
            System.out.println("Student with ID: "+ studentID + " is not enrolled in course: "+  courseCode);
        }
    
    }

    public void removeStudent(String studentID){
        if(enrolledStudents.contains(courseCode)){
            enrolledStudents.remove(studentID);
            System.out.println("Removed student with ID: " + studentID + "from course: " + courseCode);
        }else{
            System.out.println("Student with ID: " + studentID + " is not enrolled in course: " + courseCode);
        }
    }

    public ArrayList<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    
}
