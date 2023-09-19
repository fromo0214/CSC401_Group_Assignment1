import java.util.*;
public class RegistrarOffice {
    static Random rand = new Random();
    public static void main(String[] args) {
        //each student has a unique student ID, and each course has a unique course code
        HashMap<Integer,Integer> students = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> courses = new HashMap<Integer,Integer>();
        

        int studentID[] = new int[5];
        int courseNumber[] = new int[5];

        assignStudentID(studentID);
        // assignCourseNumber(courseNumber);
        

        // students.put(studentID, courseNumber);        

    }

    // private static void assignCourseNumber(int[] array) {
    //     int num;
    //     for(int i = 0; i < array.length;i++){
    //         array[i] = rand.nextInt();
    //         System.out.println(array[i]);   
    //     }
    //     // return array;
    // }

    private static void assignStudentID(int[] array) {
        for(int i = 0; i < array.length;i++){
            array[i] = rand.nextInt();
            System.out.println(array[i]);
        }
    }
    
}