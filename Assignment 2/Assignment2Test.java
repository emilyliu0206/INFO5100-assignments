package assignment2;

public class Assignment2Test {
    public static void main (String[] args) {
        Employee employee1 = new Employee( 15, "John",60, 1000 );
        Employee employee2 = new Employee( 32, "kun",20,600000);
        Employee employee3 = new Employee( 99,"iurhgpao9j",34,9000 );
        Employee employee4 = new Employee( 10,"ming",79,5000 );

        Employee[] employees ={employee1,employee2,employee3,employee4};
        Assignment2 test1 =  new Assignment2();
        double result = test1.salaryGreaterThanFiveThousand(employees);
        System.out.println(result);

        test1.fizzBuzz(employee1);
        test1.fizzBuzz(employee2);
        test1.fizzBuzz(employee3);
        test1.fizzBuzz(employee4);


        double Tax1 = test1.calculateTax( employee1 );
        double Tax2 =test1.calculateTax( employee2 );
        double Tax3 = test1.calculateTax( employee3 );
        double Tax4 = test1.calculateTax( employee4 );
        System.out.println(Tax1);
        System.out.println(Tax2);
        System.out.println(Tax3);
        System.out.println(Tax4);

        test1.swap( employee1,employee2 );
        double Salary1 = employee1.getSalary();
        double Salary2 = employee2.getSalary();
        System.out.println(Salary1);
        System.out.println(Salary2);

        int count = test1.employeesAgeGreaterThan50( employees );
        System.out.println(count);

        test1.reverseFirstName( employee1 );
        String FirstName = employee1.getFirstName();
        System.out.println(FirstName);

        test1.isContainDigit( employee1 );
        test1.isContainDigit( employee2 );
        test1.isContainDigit( employee3 );

        test1.tripleSalary( employee1 );
        double Salary3 = employee1.getSalary();
        System.out.println(Salary3);
        test1.tripleSalary( employee2 );
        double Salary4 = employee2.getSalary();
        System.out.println(Salary4);

        String[] employees2 = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        Employee[] test = test1.createEmployees( employees2 );
        for (Employee i : test){
            String TestFirstName = i.getFirstName();
            System.out.println(TestFirstName);
        }
    }


}
