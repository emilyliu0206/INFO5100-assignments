package Assignment8.StudentInformationSystemInterface.view;

import Assignment8.BaseFrame;
import Assignment8.StudentInformationSystemInterface.controller.StudentInformationController;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;

public class StudentInformationSystemView extends BaseFrame {

    private JLabel IDLable, nameLable;
    private JTextField IDText, nameText;
    private JComboBox<String> genderOptions;
    private JButton addButton;
    private JTable studentsTable;
    private DefaultTableModel model;

    @Override
    public void create() {
        IDLable = new JLabel("Enter Student ID : ");
        nameLable = new JLabel("Enter Student Name : ");
        IDText = new JTextField(20);
        nameText = new JTextField(20);
        genderOptions = new JComboBox<>(new String[]{"Female", "Male"});
        addButton = new JButton("Add");
        studentsTable = new JTable();
        model = (DefaultTableModel) (studentsTable.getModel());
    }

    public void add(Container con) {
        BoxLayout boxLayout = new BoxLayout(con,BoxLayout.Y_AXIS);
        con.setLayout(boxLayout);

        addStudentsTable(con);
        addIDComponent(con);
        addNameComponent(con);
        addGenderOptions(con);
        addAddButton(con);
    }
    @Override
    public void addListeners() {
        addButton.addActionListener((e)->parseStudentInfo());
    }

    private void parseStudentInfo(){
        String student_id = this.IDText.getText();
        String student_name = this.nameText.getText();
        String student_gender = (String)this.genderOptions.getSelectedItem();
        if (StudentInformationController.addStudentInfo(student_id, student_name, student_gender)){
            model.addRow(new String[]{student_id, student_name, student_gender});
            model.fireTableDataChanged();
        } else{
            JOptionPane.showMessageDialog(studentsTable, "This student has already existed!");
        }
    }

    private void addStudentsTable(Container con) {
        String[] columnNames = {"id", "name", "gender"};
        this.model.setColumnIdentifiers(columnNames);
        model.fireTableDataChanged();
        con.add(new JScrollPane(studentsTable));
    }

    private void addAddButton(Container con) {
        con.add(addButton);
    }

    private void addGenderOptions(Container con){
        con.add(genderOptions);
    }

    private void addNameComponent(Container con) {
        addComponents(con, nameLable, nameText);
    }

    private void addIDComponent(Container con) {
        addComponents(con, IDLable, IDText);
    }

    private void addComponents(Container con, Component a, Component b) {
        JPanel panel = new JPanel();
        panel.add(a);
        panel.add(b);

        con.add(panel);
    }
}
