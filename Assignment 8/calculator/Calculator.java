package Assignment8.calculator;

import Assignment8.BaseFrame;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class Calculator extends BaseFrame {

    private JLabel firstLable, secondLable,  operationLable, resultLable;
    private JTextField firstText, secondText;
    private JComboBox optionsForOperation;
    private JButton computeButton;

    @Override
    public void create() {
        firstLable = new JLabel("First Number : ");
        secondLable = new JLabel("Second Number : ");
        operationLable = new JLabel("Operation : ");
        resultLable = new JLabel("Result : ");

        firstText = new JTextField(10);
        secondText =new JTextField(10);

        optionsForOperation = new JComboBox(new String[] {"+", "-", "*", "/"});

        computeButton = new JButton("Compute");

    }

    @Override
    public void add(Container con) {
        GridLayout gl = new GridLayout(5,1);
        con.setLayout(gl);
        addFirstComponent(con);
        addOptions(con);
        addSecondComponent(con);
        addComputeButton(con);
        addResultsLabel(con);

    }

    private void addResultsLabel(Container con) {
        con.add(resultLable);
    }

    private void addComputeButton(Container con) {
        con.add(computeButton);
    }

    private void addSecondComponent(Container con) {
        addComponents(con,secondLable,secondText);
    }

    private void addOptions(Container con) {
        addComponents(con,operationLable,optionsForOperation);
    }

    private void addComponents(Container con, Component a, Component b) {
        JPanel panel = new JPanel();
        panel.add(a);
        panel.add(b);

        con.add(panel);
    }

    private void addFirstComponent(Container con) {
        addComponents(con,firstLable,firstText);
    }

    void calculateAndStoreResult(){
        int a;
        int b;
        try{
            a = Integer.parseInt(firstText.getText());
            b = Integer.parseInt(secondText.getText());
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(this,"Number should be entered in the first text field");
            throw e;
        }
        try{
            b = Integer.parseInt(secondText.getText());
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(this,"Number should be entered in the second text field");
            throw e;
        }
        String operation =optionsForOperation.getSelectedItem().toString();
        int result = getResult(a,b,operation);
        String answer = a + " " + operation + " " + b + " = " +result;
        resultLable.setText("Result : " + answer);
    }

    private int getResult(int a, int b, String operation) {
        if (operation == "+"){
            return a + b;
        }
        if (operation == "-") {
            return a - b;
        }if (operation == "*"){
            return a * b;
        }
        return a / b;
    }


    @Override
    public void addListeners() {
        computeButton.addActionListener((e) -> calculateAndStoreResult());

    }

    public static void main(String[] args) {
        new Calculator();

    }
}
