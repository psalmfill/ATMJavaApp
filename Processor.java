/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import java.util.Scanner;
/**
 *
 * @author Samfield
 */
public class Processor {
    Scanner scanner  = new Scanner(System.in);
   static int  trialCount =3;
    int option ;
    int logpin;
    int oldpin;     
    int newpin; 
    int confirmpin;
    double amount;
    String yesNo;
    String start = "y";
    Account account;
    
    public Processor(Account account){
        this.account = account;
    }
    public void start(){
        
       while (start.toUpperCase().equals("Y")){
           this.showHeader();
           this.setDisplay("Do you want to continue with another transaction (Y/N):");
           scanner = new Scanner(System.in);
           start = scanner.nextLine();
           
       }
    }
    
    public void getlogin(){
        this.setDisplay("Enter your pin");
        this.logpin = this.scanner.nextInt();
        if(this.checkPin(this.logpin)){
            this.showMenu();
        }else{
            this.setDisplay("Invalid Login try again " + trialCount +" trial left");
            
            if(trialCount > 0){
                trialCount--;
                this.getlogin();
                
            }else{
                 this.setDisplay("you have exceeded the trial period");
            }
            
        }
    }
    public void showHeader(){
        this.setDisplay("Welcome to " + this.account.bankName);
        this.setDisplay(this.account.getAccountName());
        this.getlogin();
    }
    
    public void showMenu(){
        
        this.setDisplay("1.Balance \t4.Withdraw \n2.Change pin \t5.Transfer\n3.Deposit");
        this.setDisplay("Select an Option");
        option = scanner.nextInt();
        
        switch(option){
            case 1 :
                this.getBalance();
                break;
            case 2 :
                this.changePin();
                break;
            case 3:
                  this.doDeposit();
                break;
            case 4:
                this.withdraw();
                break;
            default:
                this.transfer();
                break;
        }
    }
    public void changePin(){
        
        this.setDisplay("Enter old pin");
        this.oldpin = scanner.nextInt();
        
        if(this.checkPin(oldpin)){
            this.setDisplay("Enter new pin");
            this.newpin = scanner.nextInt();
            this.setDisplay("Confirm pin");
            this.confirmpin = scanner.nextInt();
            if(this.confirmpin == this.newpin ){
                this.account.setPin(this.newpin); 
                this.setDisplay("Pin Change Successfully");
            }
            else {
                this.setDisplay("Pin Mismatch try again");
                this.changePin();
            }
        }else{
            this.setDisplay("Old pin is Invalid");
        }
       
       
    }
    
    public boolean checkPin(int pin){
        if(this.account.pin == pin){
            return true;
        }
        return false;
    }
    
    public void getBalance(){
        this.setDisplay("" + this.account.getBalance());
    }
    
    public boolean isWithdrawable(double amount){
        if(this.account.balance > amount){
            return true;
        }
        else
        {
            return false;
        }
    }
    public void doWithdraw(double amount ){
        if(this.isWithdrawable(amount)){
            this.account.withdraw(amount);
            this.setWithdrawalMessage();
        }else{
            this.setDisplay("Insufficient Balance");
        }
    }
    public void withdraw(){
        this.setDisplay("1.20000 \t2.10000 \t3.5000 \t4.2000 \t5.1000 \t6.500 \t7.Other");
        this.setDisplay("Select an Option");

        option = scanner.nextInt();
        
        switch (option){
            case 1:
                this.doWithdraw(20000);
                break;
            case 2:
                this.doWithdraw(10000);
                break;
            case 3:
               this.doWithdraw(5000);
                break;
            case 4:
                this.doWithdraw(2000);
                break;
            case 5:
                this.doWithdraw(1000);
                break;
            case 6:
                this.doWithdraw(500);
                break;
            default:
                this.setDisplay("Enter your ammount");
                amount = scanner.nextDouble();
                this.doWithdraw(amount);
                break;
        }
    }
    
    public void transfer(){
        this.setDisplay(("Enter transfer Amount"));
        amount = scanner.nextDouble();
        this.account.withdraw(amount);
        this.setDisplay("Your transfer was successful \nNew balance: " + this.account.balance);
    }
    public void setDisplay(String text){
        System.out.println(text);
    }
    
    public void setWithdrawalMessage(){
        this.setDisplay("Your Withdrawal was successful \nNew balance : "+this.account.balance);
    }
    
    public void doDeposit(){
        this.setDisplay("Enter amount to deposit");
        double amt = scanner.nextDouble();
        
        account.deposit(amt);
        this.setDisplay("You account has been deposited with "+amt);
        this.setDisplay("New account balance is " + account.balance);
    }
    
}
