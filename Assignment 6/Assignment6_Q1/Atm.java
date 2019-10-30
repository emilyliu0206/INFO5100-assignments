package Assignment6_Q1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Atm {
    float availableAmountInMachine;
    float transactionFee;

    private HashSet<User> users;
    private HashMap<String, AccountInfo> userData;

    Atm(float availableAmountInMachine, float transactionFee, HashMap<String, AccountInfo> userData, HashSet<User> users) {
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
        this.userData = userData;
        this.users = users;
    }

    String CreatNewUser(String name, int age, String address, String phoneNumber, String password) {
        int new_bankAccountNumberInt = new Random().nextInt(899999999) + 100000000;
        while (userData.containsKey(String.valueOf(new_bankAccountNumberInt))) {
            new_bankAccountNumberInt = new Random().nextInt(899999999) + 100000000;
        }
        String new_bankAccountNumber = String.valueOf(new_bankAccountNumberInt);
        User user = new User(name, age, address, phoneNumber, new_bankAccountNumber);
        users.add(user);
        AccountInfo accountInfo = new AccountInfo(password);
        userData.put(new_bankAccountNumber, accountInfo);
        return new_bankAccountNumber;
    }

    User Login(String bankAccountNumber, String password) {
        if (!userData.containsKey(bankAccountNumber)) {
            return null;
        } else {
            if (password.equals(userData.get(bankAccountNumber).getPassword())) {
                for (User user : users) {
                    if (bankAccountNumber.equals(user.getBankAccountNumber())) {
                        return user;
                    }
                }
            }
        }
        return null;
    }

    AccountInfo getAccountInfo(User user){
        return userData.get(user.getBankAccountNumber());
    }
    public void withDrawal(User user, float withdraw_value) {
        float balance = userData.get(user.getBankAccountNumber()).getBalance();
        if (balance < withdraw_value + transactionFee) {
            System.out.println("You don't have enough balance in your account");
            ;
        } else {
            balance = balance - withdraw_value - transactionFee;
            String transaction_message = "withDrew amount: " + withdraw_value +
                    ", transaction fee: " + transactionFee +
                    ", current balance" + balance;
            userData.get(user.getBankAccountNumber()).setBalance(balance);
            userData.get(user.getBankAccountNumber()).addTransactions(transaction_message);
            System.out.println(transaction_message);
            System.out.println("Thanks for banking with us!");
        }
    }

    public void deposit(User user, float deposit_value) {
        float balance = userData.get(user.getBankAccountNumber()).getBalance();
        if (balance + deposit_value < transactionFee) {
            System.out.println("You don't have enough balance in your account");
            ;
        } else {
            balance = balance + deposit_value - transactionFee;
            String transaction_message = "Deposit amount: " + deposit_value +
                    ", transaction fee: " + transactionFee +
                    ", current balance" + balance;
            userData.get(user.getBankAccountNumber()).setBalance(balance);
            userData.get(user.getBankAccountNumber()).addTransactions(transaction_message);
            System.out.println(transaction_message);
            System.out.println("Thanks for banking with us!");
        }
    }

    public void changePassword(User user, String new_password) {
        userData.get(user.getBankAccountNumber()).setPassword(new_password);
    }

    public void findPassword(String bankAccountNumber, String name, String phoneNumber, String new_password) {
        if (userData.containsKey(bankAccountNumber)) {
            for (User user : users) {
                if (user.getBankAccountNumber().equals(bankAccountNumber)) {
                    if (user.getName().equals(name) &&
                            user.getPhoneNumber().equals(phoneNumber) &&
                            user.getName().equals(name)) {
                        userData.get(bankAccountNumber).setPassword(new_password);
                        System.out.println("You have successfully updated your password");
                        return;
                    }
                }
            }
        }
        System.out.println("Incorrect information!");
    }
}

