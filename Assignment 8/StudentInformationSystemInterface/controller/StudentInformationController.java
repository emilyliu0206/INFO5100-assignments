package Assignment8.StudentInformationSystemInterface.controller;

import Assignment8.StudentInformationSystemInterface.model.StudentData;
import Assignment8.StudentInformationSystemInterface.model.StudentModel;

public class StudentInformationController {
    public static boolean addStudentInfo(String StudentId, String StudentName, String StudentGender){
        if (!StudentData.students.containsKey(StudentId)){
            StudentModel new_student = new StudentModel(StudentId, StudentName, StudentGender);
            StudentData.students.put(StudentId, new_student);
            return true;
        } else{
            return false;
        }
    }
}
