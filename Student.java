import java.util.ArrayList;
import java.util.List;

public class Student {

    private String studentID;
    private String name;
    private List<String> enrolledCourses;


   public Student(String studentID,String name){
    this.studentID = studentID;
    this.name = name;
    this.enrolledCourses = new ArrayList<>();
   }

   public void setStudentID(String studentID) {
       this.studentID = studentID;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getStudentID() {
       return studentID;
   }

   public String getName() {
       return name;
   }

   public void enrollInCourse(String courseCode){
    if(!enrolledCourses.contains(courseCode)){
        enrolledCourses.add(courseCode);
        System.out.println(name + " has enrolled in course: " + courseCode);
    }else{
        System.out.println(name+ " is already enrolled in course: " + courseCode);
    }
   }

   public void dropCourse(String courseCode){
    if(enrolledCourses.contains(courseCode)){
        enrolledCourses.remove(courseCode);
        System.out.println(name + " has dropped course: "+ courseCode);
    }else{
        System.out.println(name + " is not enrolled in course: "+ courseCode);
    }
   }

   public List<String> getEnrolledCourses() {
       return enrolledCourses;
   }

}