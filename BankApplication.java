
import java.util.HashMap;
import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {

        HashMap<Integer,Account> allAcc=new HashMap<>();
        String[] str = {"puwi","Dina","Raj","Rajesh","Dev","kavi","Ram","Mahi","Kane","Tom"};
        String[] phn={"+1234567890","+9876543210","+5551234567","+9998887766","+1112223333","+7776665555","+4445556666"
                ,"+1239876543"," +8765432109","+987654390"};
        int randomNo=1111;
        for(int i=1111;i<1121;i++){
            Account newAccount=new Account(i,0,str[i-1111],phn[i-1111]);
            allAcc.put(i,newAccount);
            randomNo++;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("______________Welcome to XYZ BAnk_______________");
        System.out.println("Are you a new customer for our bank press y/n");

        char ch=sc.next().charAt(0);
        if(ch=='y'){
            createAcc(randomNo,allAcc);
        }

        Account account = getAccount(allAcc);
        boolean flag=true;
        while (flag) {
            System.out.print("Enter your option\n '1' - Check Balance \n " +
                    "'2' - Withdraw \n '3' - Deposit \n'4' - Display account Details\n'5' - switch account \n'6' - Exit\n");
            int option = sc.nextInt();
            switch (option) {
                case 1 -> account.checkBal();
                case 2 -> {
                    System.out.println("Enter the amount to be withdrawn");
                    int wAmount = sc.nextInt();
                    account.withdraw(wAmount);
                }
                case 3 -> {
                    System.out.println("Enter the amount to be Deposited");
                    int dAmount = sc.nextInt();
                    account.deposit(dAmount);
                }
                case 4 ->account.getAccDetails();
                case 5 -> {
                    System.out.println("Enter the another bank account:");
                    account=getAccount(allAcc);

                    }
                case 6 -> {
                    System.out.println("Thank you Visit Again");
                    flag=false;
                }
            }
        }

    }
    private static void createAcc(int randomNo, HashMap<Integer,Account> allAcc){
        Scanner sc = new Scanner(System.in);
        System.out.println("To Create an Account with the Us");
        System.out.println("Enter your name:");
        String name=sc.next();
        System.out.println("Enter your phone number:");
        String phone=sc.next();
        System.out.println("Enter the minimum deposit amount:");
        int minDep=sc.nextInt();
        Account newAccount=new Account(randomNo,minDep,name,phone);
        System.out.println("Your account number is:"+randomNo);
        allAcc.put(randomNo,newAccount);
    }

    private static Account getAccount(HashMap<Integer,Account> allAcc) {
        System.out.println("Enter Your Account Number:");
        Scanner sc = new Scanner(System.in);
        Account account;
        while (true){
            try {
                int accNo=sc.nextInt();
                if(allAcc.containsKey(accNo)){
                    account=allAcc.get(accNo);
                    return account;
                }else{
                    throw new RuntimeException();
                }
            }
            catch (Exception e) {
                System.out.println("Wrong Account Number Enter correct number");
            }
        }
    }
}
