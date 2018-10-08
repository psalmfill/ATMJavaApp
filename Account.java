/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author Samfield
 */
public class Account {
    // declare the variable needed for the atm
    int pin;
    double balance;
    String accountName;
    String bankName;
    
    public Account(
       String name,String bank,int pin, double balance
    ){
       this.accountName = name;
       this.bankName = bank;
       this.pin = pin;
       this.balance = balance;
    }
    public double getBalance(){
        return this.balance;
    }
    
    public void setAccountName(String name ){
        this.accountName = name;
    }
    
    public String getAccountName(){
        return this.accountName;
    }
    
    public void setBankName(String bankname){
        this.bankName=bankname;
    }
    public String getBankName(){
        return this.bankName;
    }
    
    public int getPin(){
        return this.pin;
    }
    public void setPin(int newpin){
     
            this.pin = newpin;
    }
    public void withdraw(double amount){
        this.balance -=amount;
    }
    
    public void deposit(double amount){
        this.balance +=amount;
    }
    
    public void transfer(Account account, double ammount){
        account.deposit(ammount);
        this.withdraw(ammount);
    }
    
}
