import java.util.*;
public class RegistrarOffice {

        private HashMap<String,Student> students;
        private TreeMap<String,Course> courses;

        public RegistrarOffice(){
            students = new HashMap<>();
            courses = new TreeMap<>();
        }

        //Methods to enroll students in course
        public void enrollStudentInCourse(String studentID, String courseCode){
            //checks if student and course exist
            if(students.containsKey(studentID) && courses.containsKey(courseCode)){
                Student student = students.get(studentID);
                Course course = courses.get(courseCode);

                //checks for schedules overlapping
                if(!scheduleConflict(student, course)){
                    student.enrollInCourse(courseCode);
                    course.addStudent(studentID);
                    System.out.println(student.getName() + " has been enrolled in course: " + course.getCourseName());
                }else{
                    System.out.println("Schedules conflict! Cannot enroll student.");
                }
            }else{
                System.out.println("Student or course does not exist.");
            }
        }
        //Method to drop students from the courses
        public void dropStudentFromCourse(String studentID, String courseCode){
            //checks if student and course exist
            if(students.containsKey(studentID) && courses.containsKey(courseCode)){
                Student student = students.get(studentID);
                Course course = courses.get(courseCode);

                student.dropCourse(courseCode);
                course.removeStudent(studentID);
                System.out.println(student.getName() + " has been dropped from course " + course.getCourseName());
            }else{
                System.out.println("Student or course does not exist.");
            }
        }

        private boolean scheduleConflict(Student student, Course course) {
            return false;
        }


        public static void main(String[] args) {
            
        }

    
}