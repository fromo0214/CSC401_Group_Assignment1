import java.util.*;
public class RegistrarOffice {

        private HashMap<String,Student> studentsMap;
        private TreeMap<String,Course> coursesTree;

        public RegistrarOffice(){
            studentsMap = new HashMap<>();
            coursesTree = new TreeMap<>();
        }

        //adds a student to the system
        public void addStudent(Student student){
            String studentID = student.getStudentID();
            if(!studentsMap.containsKey(studentID)){
                studentsMap.put(studentID, student);
                System.out.println("Student added: "+ student.getName());
            }else{
                System.out.println("Student with ID " + studentID + " already exists.");
            }
        System.out.println("---------------------------------------------------");

        }

        //adds a course to the system
        public void addCourse(Course course){
            String courseCode = course.getCourseCode();
            if(!coursesTree.containsKey(courseCode)){
                coursesTree.put(courseCode, course);
                System.out.println("Course added: " + course.getCourseName());
            }else{
                System.out.println("Course with ID " + courseCode + " already exists.");
            }
            System.out.println("---------------------------------------------------");

        }


        //Methods to enroll students in course
        public void enrollStudentInCourse(String studentID, String courseCode){
            //checks if student and course exist
            if(studentsMap.containsKey(studentID) && coursesTree.containsKey(courseCode)){
                Student student = studentsMap.get(studentID);
                Course course = coursesTree.get(courseCode);

                //checks for schedules overlapping
                if(!scheduleConflict(student, course)){
                    student.enrollInCourse(courseCode);
                    course.addStudent(studentID);
                    System.out.println(student.getName() + " has been enrolled in course: " + course.getCourseName());
                }else{
                    System.out.println("Schedules conflict! Cannot enroll student: "+ student.getName()+ " in " + course.getCourseName());
                }
            }else{
                System.out.println("Student or course does not exist.");
            }
                        System.out.println("---------------------------------------------------");

        }
        //Method to drop students from the courses
        public void dropStudentFromCourse(String studentID, String courseCode){
            //checks if student and course exist
            if(studentsMap.containsKey(studentID) && coursesTree.containsKey(courseCode)){
                Student student = studentsMap.get(studentID);
                Course course = coursesTree.get(courseCode);

                student.dropCourse(courseCode);
                course.removeStudent(studentID);
                System.out.println(student.getName() + " has been dropped from course: " + course.getCourseName());
            }else{
                System.out.println("Student or course does not exist.");
            }
                        System.out.println("---------------------------------------------------");

        }

        //method to display the course roster of all students registered to the class 
        public void generateCourseRoster(String courseCode){
            if(coursesTree.containsKey(courseCode)){
                Course course = coursesTree.get(courseCode);
                List<String> enrolledStudents = course.getEnrolledStudents();

                System.out.println("Roster for course, "+ courseCode +" - " +course.getCourseName()+ ":");
                for(String studentID : enrolledStudents){
                    Student student = studentsMap.get(studentID);
                    System.out.println("Student ID: " + studentID + ", Name: " + student.getName());
                }
            }else{
                System.out.println("Course does not exist.");
            }
                        System.out.println("---------------------------------------------------");

        }

        public void viewStudentSchedule(String studentID){
            if(studentsMap.containsKey(studentID)){
                Student student = studentsMap.get(studentID);
                List<String> enrolledCourses = student.getEnrolledCourses();

                System.out.println("Schedule for student " + student.getName() + " (ID: " + studentID + ")");
                for(String courseCode : enrolledCourses){
                    Course course = coursesTree.get(courseCode);
                    System.out.println("Course Code: " + courseCode+ ", Course Name: " + course.getCourseName());
                }
            }else{
                System.out.println("Student does not exist.");
            }
                        System.out.println("---------------------------------------------------");

        }

        private boolean scheduleConflict(Student student, Course course) {
            List<String> enrolledCourses = student.getEnrolledCourses();

            //Extract the schedule information for the new course
            String newCourseDay = course.getScheduleDay();
            String newCourseTimeSlot = course.getScheduleTimeSlot();

            //Iterate through the student's enrolled courses
            for(String courseCode : enrolledCourses){
                Course enrolledCourse = coursesTree.get(courseCode);

                //extract the schedule information for the enrolled course
                String enrolledCourseDay = enrolledCourse.getScheduleDay();
                String enrolledCourseTimeSlot = enrolledCourse.getScheduleTimeSlot();

                if(newCourseDay.equals(enrolledCourseDay) && newCourseTimeSlot.equals(enrolledCourseTimeSlot)){
                    return true; //conflict was found in the schedule
                }
                
            }
            //conflict was not found 
            return false;
        }


        public static void main(String[] args) {

            //creating database for the registrar office
            RegistrarOffice registrarOffice = new RegistrarOffice();

            //creating students
            Student fernando = new Student ("0214", "Fernando");
            Student chris = new Student ("0544", "Chris");

            //creating courses
            Course csc401 = new Course("CSC401", "Analysis of Algorithms", "Tuesday","2:30 PM - 3:45PM");
            Course csc311 = new Course("CSC311", "Data Structures", "Monday", "11:00 AM - 12:15 PM");
            Course history = new Course("HIS100","History","Tuesday", "1:00PM - 2:00 PM");
            Course math = new Course("MAT300", "Calculus 1", "Tuesday", "1:00PM - 2:00 PM");

            //adds the students to the database
            registrarOffice.addStudent(chris);
            registrarOffice.addStudent(fernando);
  

            //adds courses to the database
            registrarOffice.addCourse(history);
            registrarOffice.addCourse(csc401);
            registrarOffice.addCourse(csc311);
            registrarOffice.addCourse(math);

            //enrolls students in the courses by their studentID and the courseCode
            registrarOffice.enrollStudentInCourse("0214", "CSC401");
            registrarOffice.enrollStudentInCourse("0544", "CSC401");
            registrarOffice.enrollStudentInCourse("0214", "HIS100");
            registrarOffice.enrollStudentInCourse("0214", "MAT300");

            //displays students in the course by using course code
            registrarOffice.generateCourseRoster("CSC401");

            //drops student from course by using their student id and course code
            registrarOffice.dropStudentFromCourse("0544", "HIS100");

            //displays the student's schedule by using their id
            registrarOffice.viewStudentSchedule("0544");
            registrarOffice.viewStudentSchedule("0214");
 
        }

 

    
}