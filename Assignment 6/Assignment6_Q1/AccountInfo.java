package Assignment6_Q1;

import java.util.LinkedList;
import java.util.List;

public class AccountInfo {
    String password;
    float balance;
    List<String> transactions;

    public AccountInfo(String password){
        this.password = password;
        this.balance = 0;
        transactions = new LinkedList<>();
    }

    public void setPassword(String new_password){
        this.password = password;
    }

    public String getPassword() { return this.password; }

    public float getBalance(){
        return this.balance;
    }

    public void setBalance(float balance) {this.balance = balance;}

    public List<String> getTransactions(){
        return transactions;
    }

    public void addTransactions(String transaction){
        transactions.add(transaction);
    }
}
