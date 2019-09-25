package assignment2;

import java.util.concurrent.CountDownLatch;
import java.util.zip.CheckedOutputStream;

public class Assignment2 {
    /*
       This method should return the sum of salaries of employees having salary greater than 5000
       Note: Employee array is passed, not employee
    */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        double totalSalary = 0;
        for (Employee employee: employees) {
            double Salary = employee.getSalary();
            if (Salary > 5000) {
                totalSalary = totalSalary + Salary;
            }
        }
    return totalSalary;
    }


    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        int Id = employee.getId();
        if (Id % 5 == 0 & Id % 3 == 0) {
            System.out.println("FizzBuzz");
        }else if (Id % 3 == 0) {
            System.out.println("Fizz");
        }else if (Id % 5 == 0) {
            System.out.println("Buzz");
        }
    }


    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public double calculateTax(Employee employee) {
        double Salary = employee.getSalary();
        double taxRate ;
        if (Salary <= 2500) {
            taxRate = 0.10;
        }else if (Salary >2500 & Salary <= 5000) {
            taxRate = 0.25;
        }else {
            taxRate = 0.35;
        }
        double Tax = Salary * taxRate;
        return Tax;
    }


    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        double firstEmployeeSalary = firstEmployee.getSalary();
        double secondEmployeeSalary = secondEmployee.getSalary();
        firstEmployee.setSalary(secondEmployeeSalary);
        secondEmployee.setSalary(firstEmployeeSalary);
    }


    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        int Count = 0;
        for (Employee employee : employees) {
            int Age = employee.getAge();
            if (Age > 50) {
                Count += 1;
            }
        }
        return Count;
    }


    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        String FirstNameOriginal = employee.getFirstName();
        String FirstNameReversed = "";
        for (int i = FirstNameOriginal.length()-1 ; i >= 0; i--) {
            FirstNameReversed = FirstNameReversed + FirstNameOriginal.charAt(i);
        }
        employee.setFirstName( FirstNameReversed );
    }


    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public void isContainDigit(Employee employee) {
        String FirstName = employee.getFirstName();
        int result = 0;
        for (int i = 0; i < FirstName.length(); i++) {
           if(Character.isDigit(FirstName.charAt(i))){
               System.out.println("true");
               return;
           }
        }
        System.out.println("false");
    }


    /*
       Write a method to raise an employee's salary to three times of his/her original salary.
       Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
       DO NOT change the input in this method.
       Try to add a new method in Employee class: public void raiseSalary(double byPercent)
       Call this new method.
    */
    public void tripleSalary(Employee employee) {
        raiseSalary(2,employee);
    }

    private void raiseSalary(double byPercent,Employee employee) {
        double OriginalSalary = employee.getSalary();
        double AfterSalary = OriginalSalary * ( 1 + byPercent );
        employee.setSalary(AfterSalary);
    }
    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        for (int i = 0; i < employeesStr.length; i++) {
            String employee = employeesStr[i];
            String[] employeeInfoList = employee.split(",");
            employees[i] = new Employee(Integer.parseInt(employeeInfoList[0]),
                    employeeInfoList[1],
                    Integer.parseInt(employeeInfoList[2]),
                    Double.parseDouble(employeeInfoList[3]));
        }
        return employees;
    }
}

