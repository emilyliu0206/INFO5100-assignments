import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Course {

    private int courseId;
    private String courseName;
    private int maxCapacity;
    private int professorId;
    private int credits;
    private int[] studentIds;

    Course(int courseId){
        this.courseId = courseId;
        if (courseId <= 0 ){
            throw new IllegalArgumentException( "Course Id should be positive" );
        }
    }

    Course(int courseId, int professorId){
        this.courseId = courseId;
        this.professorId = professorId;
        if (courseId <= 0 ){
            throw new IllegalArgumentException( "Course Id should be positive" );
        }else if (professorId < 100000 || professorId > 999999){
            throw new IllegalArgumentException( "Professor Id should be a six digit integer" );
        }
    }

    Course(int courseId, int professorId, int credits){
        this.courseId = courseId;
        this.professorId = professorId;
        this.credits = credits;
        if (courseId <= 0 ){
            throw new IllegalArgumentException( "Course Id should be positive" );
        }else if (professorId < 100000 || professorId > 999999){
            throw new IllegalArgumentException( "Professor Id should be a six digit integer" );
        }else if (credits < 0 || credits> 9 ){
            throw new IllegalArgumentException( "Credits should be a single digit but greater than 0" );
        }
    }

    public int getCourseId(){
        return courseId;
    }

    public String getCourseName(){
        return courseName;
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public int getProfessorId(){
        return professorId;
    }

    public double getCredits(){
        return credits;
    }

    public int[] getStudentIds(){
        return studentIds;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
        if (courseId <= 0 ){
            throw new IllegalArgumentException( "Course Id should be positive" );
        }
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
        if (courseName.length() < 10 || courseName.length() > 60){
            throw new IllegalArgumentException( "Course name should be a string with minimum length 10 and maximum 60" );
        }
    }

    public void setMaxCapacity(int maxCapacity){
        this.maxCapacity = maxCapacity;
        if (maxCapacity < 10 || maxCapacity > 100){
            throw new IllegalArgumentException( "Max capacity should be a number with minimum 10 and maximum 100" );
        }
    }

    public void setProfessorId(int professorId){
        this.professorId = professorId;
        if (professorId < 100000 || professorId > 999999){
            throw new IllegalArgumentException( "Professor Id should be a six digit integer" );
        }
    }

    public void setCredits(int credits){
        this.credits = credits;
        if (credits <= 0 || credits> 9 ){
            throw new IllegalArgumentException( "Credits should be a single digit but greater than 0" );
        }
    }

    public void setStudentIds(int[] studentIds){
        this.studentIds = studentIds;
    }

    public void registerStudent(int studentId){
        int[] StudentIdsBefore = this.getStudentIds();
        int i = StudentIdsBefore.length;
        StudentIdsBefore[i] = studentId;
    }

    public int[] removeDuplicates(int[] studentIds) {
        int end = studentIds.length;
        Set<Integer> deDuplicatedSet = new HashSet<Integer>();
        for(int i = 0; i < end; i++){
            deDuplicatedSet.add(studentIds[i]);
        }
        int[] deDuplicatedList = deDuplicatedSet.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return deDuplicatedList;
    }

    public int groupsOfStudents(int[] studentIds) {
        int CountEven = 0;
        int CountOdd = 0;
        for (int studentId: studentIds) {
            if (studentId % 2 == 0) {
               CountEven = CountEven + 1;
            }else {
                CountOdd = CountOdd +1;
            }
        }
        int result = (CountEven * (CountEven - 1) + CountOdd * (CountOdd - 1))/2;
        return result;
    }
}