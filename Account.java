
import java.util.ArrayList;

public class Account {
    private int accNo;
    private String name;
    private String phoneNo;
    private ArrayList<String> transaction;
    private float balance;

    Account(int accNo,float balance,String name,String phoneNo){
        this.accNo=accNo;
        this.balance=balance;
        this.name=name;
        this.phoneNo=phoneNo;
        this.transaction=new ArrayList<>();
        transaction.add("Type       |Amount     |   Balance");
    }

    public void getAccDetails(){
        System.out.println("Account Number      :   "+accNo);
        System.out.println("Account Holder name :   "+name);
        System.out.println("Contact Number      :   "+phoneNo);
        System.out.println("Transaction made    :   ");
        displayTxn(transaction);
    }
    private void displayTxn(ArrayList<String> transaction){
        for (String str:transaction) {
            System.out.println(str);
        }
    }
    public void deposit(float amount){
        if(amount<=0){
            System.out.println("Enter correct amount");
        }else{
            balance=balance+amount;
            System.out.println("Deposited Successfully");
            String str="Deposited   |+"+amount+" |"+balance;
            transaction.add(str);
        }
    }
    public void withdraw(float amount){
        if(amount>0 && amount<=balance){
            balance=balance-amount;
            System.out.println("Withdrawn successfully");
            String str="Withdraw   |-"+amount+" |"+balance;
            transaction.add(str);
        }else if(amount<=0){
            System.out.println("The amount is not applicable enter correct amount");
        }else{
            System.out.println("Insufficient Bank Balance");
        }
    }
    public void checkBal(){System.out.println(balance);
    }
}
