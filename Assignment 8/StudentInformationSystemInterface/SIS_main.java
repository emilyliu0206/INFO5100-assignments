package Assignment8.StudentInformationSystemInterface;

import Assignment8.StudentInformationSystemInterface.model.StudentModel;
import Assignment8.StudentInformationSystemInterface.view.StudentInformationSystemView;

public class SIS_main {
    public static void main(String[] args) {
        StudentModel jiaxin = new StudentModel("01","Jiaxin","female");
        StudentModel kunchen = new StudentModel("02","kunchen","male");

        new StudentInformationSystemView();
    }
}
