import java.util.*;

class User{
    static Scanner sc=new Scanner(System.in);

    int accountNo;
    String name;
    String pass;
    User next;
    User pre;
    Trans root=null;
    Trans tail=null;

    User(int accountNo,String name,String pass){
        this.accountNo=accountNo;
        this.name=name;
        this.pass=pass;
        this.next=null;
        this.pre=null;
    }

    static class Trans{
        double amount;
        String date;
        Trans nextTran;
        Trans preTrans;

        Trans(double amount,String date){
            this.amount=amount;
            this.date=date;
            this.nextTran=null;
            this.preTrans=null;
        }
    }

    public void addTransaction(double amount,String date){
        Trans newTrans=new Trans(amount, date);
        if(root==null){
            root=newTrans;
            tail=newTrans;
        }
        newTrans.preTrans=tail;
        tail=newTrans;
    }

    public void deposit(){
        System.out.print("Enter Amount For Deposit : ");
        double addAmount=sc.nextDouble();
        if(addAmount<0){
            System.out.println("Wrong amount try Again..");
            return;
        }
        sc.nextLine();
        System.out.print("Enter Date(YYYY/MM/DD) for this Transaction : ");
        String date=sc.nextLine();
        addTransaction(tail.amount+addAmount, date);
        System.out.println("Now balance : "+tail.amount);
    }

    public void withdrow(){
        System.out.println("Available Balance : "+tail.amount);
        System.out.print("Enter Amount For Withdrow : ");
        double withdrowAmount=sc.nextDouble();
        if(withdrowAmount<0){
            System.out.println("Wrong amount try Again..");
            return;
        }
        if(withdrowAmount>tail.amount){
            System.out.println("Insufficent Balance");
            return;
        }
        sc.nextLine();
        System.out.print("Enter Date(YYYY/MM/DD) For Transaction : ");
        String date=sc.nextLine();
        addTransaction(tail.amount-withdrowAmount,date);
        System.out.println("Now balance : "+tail.amount);
    }

    public void showBalance(){
        System.out.println("Balance : "+tail.amount);
    }

    public void showAllTrans(){
        if(tail==null){
            System.out.println("No Any Transaction");
        }

        Trans temp=tail;

        System.out.println("user name : "+name);
        System.out.println("account No : "+accountNo);
        System.out.println();

        do{
            
            System.out.println("Date : "+temp.date);
            System.out.println("Amount : "+temp.amount);
            System.out.println();
            temp=temp.preTrans;
        }while(temp!=root);
    }
}

class Main{
    static Scanner sc=new Scanner(System.in);
    static User root;
    static User tail;
    public static void main(String[] args) {
        //User u=new User();

        int ch;
        do{
            System.out.println();
            System.out.println("(1)New User (2)Already User (3)Exit");
            ch=sc.nextInt();
            switch(ch){
                case 1 : addUser();
                         break;
                case 2 : System.out.print("Enter Accout No : ");
                         int accNo=sc.nextInt();
                         sc.nextLine();
                         System.out.print("Enter Password : ");
                         String password=sc.nextLine();
                         User u=searchUser(accNo, password);
                         if(u!=null){
                            user(u);
                         }else{
                            System.out.println("This account Number not Found Try Again..");
                         }

            }
        }while(ch!=4);
    }

    public static User searchUser(int accNO,String password){
        if(root==null){
            return null;
        }
        User temp=root;
        do{
            if(temp.accountNo==accNO && temp.pass.equals(password)){
                return temp;
            }
        }while(temp!=tail);
        return null;
    }

    public static void addUser(){
        sc.nextLine();
        System.out.print("Enter Name : ");
        String name=sc.nextLine();
        System.out.print("set password : ");
        String pass=sc.nextLine();
        int accountNo=(int)(Math.random()*1000);
        System.out.println("Your Account No : "+accountNo);

        User u=new User(accountNo, name, pass);
        u.addTransaction(0, "2023/09/29");
        if(root==null){
            root=u;
            tail=u;
            user(u);
            return;
        }
        u.pre=tail;
        tail.next=u;
        
        tail=u;

        user(u);
    }

    public static void user(User u){
        int ch;
        do{
            System.out.println();
            System.out.println("(1)Deposit (2)Withdrow (3)Check Balance (4)All Transaction (5)Exit");
            ch=sc.nextInt();
            switch(ch){
                case 1 : System.out.println();
                         u.deposit();
                         break;
                case 2 : u.withdrow();
                         break;
                case 3 : u.showBalance();
                         break;
                case 4 : u.showAllTrans();
                         break;
                case 5 : return;
                default : System.out.println("Invalid Option");
            }
        }while(ch!=5);
    }
}