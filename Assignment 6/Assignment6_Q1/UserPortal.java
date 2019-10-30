package Assignment6_Q1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class UserPortal {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        Atm current_atm = new Atm(1000000, 1, new HashMap<>(), new HashSet<>());
        User user = null;

        while(true){
            System.out.println("Please choose From:");
            System.out.println("Type 1: Current User");
            System.out.println("Type 2: New User, I want to create one!");
            int userChoice = scanner.nextInt();
            if (userChoice == 1){
                // User Login
                System.out.println("Please tell me what you want to do with your account:");
                System.out.println("Type 1: Login!");
                System.out.println("Type 2: Reset Password");
                int existingUserChoice = scanner.nextInt();
                if (existingUserChoice == 1){
                    System.out.println("Please enter your account number: ");
                    String account_number= scanner.next();
                    System.out.println("Please enter your password: ");
                    String password = scanner.next();
                    user = current_atm.Login(account_number, password);
                    // Only when user logged in, we proceed
                    break;
                } else if (existingUserChoice == 2){
                    System.out.println("Please enter AccountNumber");
                    String account_number= scanner.next();
                    System.out.println("Please enter name");
                    String name= scanner.next();
                    System.out.println("Please enter phoneNumber");
                    String phone_number= scanner.next();
                    System.out.println("Please enter new password");
                    String new_password= scanner.next();
                    current_atm.findPassword(account_number, name, phone_number, new_password);
                } else{
                    System.out.println("Incorrect Input, Goodbye");
                }

            } else if (userChoice == 2){
                System.out.println("Please enter your name");
                String name= scanner.next();
                System.out.println("Please enter your age");
                int age= scanner.nextInt();
                System.out.println("Please enter your address");
                String address= scanner.next();
                System.out.println("Please enter phone number");
                String phone_number= scanner.next();
                System.out.println("Please enter new password");
                String password= scanner.next();
                String account_number = current_atm.CreatNewUser(name, age, address, phone_number, password);
                System.out.println("Your account number is " + password + ", please use account number with password to login");
            } else{
                System.out.println("Incorrect Input, Goodbye");
            }
        }

        if (user != null){
            while(true){
                AccountInfo info = current_atm.getAccountInfo(user);
                System.out.println("Please choose from following options");
                System.out.println("Type 1: availableBalance ");
                System.out.println("Type 2: withdraw ");
                System.out.println("Type 3: deposit ");
                System.out.println("Type 4: recentTransactions ");
                System.out.println("Type 5: changePassword ");
                System.out.println("Type 6: log out ");
                int loggedInUserChoice = scanner.nextInt();
                if (loggedInUserChoice == 6){
                    break;
                }else if(loggedInUserChoice == 1){
                    System.out.println("available balance: " + info.getBalance());
                }else if(loggedInUserChoice == 2){
                    System.out.println("Please enter Withdraw amount");
                    float withdraw_amount = scanner.nextFloat();
                    current_atm.withDrawal(user, withdraw_amount);
                }else if(loggedInUserChoice == 3){
                    System.out.println("Please enter Deposit amount");
                    float deposit_amount = scanner.nextFloat();
                    current_atm.deposit(user, deposit_amount);
                }else if(loggedInUserChoice == 4){
                    System.out.println("Recent Transactions");
                    List<String> all_transactions = info.getTransactions();
                    int transactions_count = all_transactions.size();
                    if (transactions_count == 0){
                        System.out.println("You don't have any transaction history");
                    } else if (transactions_count < 10){
                        for (String transaction : all_transactions){
                            System.out.println(transaction);
                        }
                    } else{
                        for (int i = 1; i < 10; i ++){
                            System.out.println(all_transactions.get(transactions_count - 1));
                        }
                    }
                }else if(loggedInUserChoice == 5){
                    System.out.println("Please enter your password:");
                    String password = scanner.next();
                    current_atm.changePassword(user, password);
                    System.out.println("Your password has been successfully changed!");
                }
            }
        }
    }
}
