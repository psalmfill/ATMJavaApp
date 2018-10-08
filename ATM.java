
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
public class ATM {
//    Scanner myScanner ;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
       Account myAccount = new Account("Samfield Hawb Bassey","Access Bank", 1234, 5000);
       Processor atmprocessor = new Processor(myAccount);
       atmprocessor.start();
    }
    
    
    
}
