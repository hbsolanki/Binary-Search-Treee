import java.util.*;

class Queue_Double_Ended_Circular_Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enrer Queue Size");
        Queue_Double_Ended_Circular qc=new Queue_Double_Ended_Circular(sc.nextInt());
        int choice;
        do{
            System.out.println("Enter Number For (1)frontEnqueue (2)rearEnqueue (3)FrontDequeue (4)rearDequeue (5)display (6)Exit");
            choice=sc.nextInt();
            switch(choice){
                case 1: qc.frontEnqueue();
                        break;
                case 2: qc.rearEnqueue();
                        break;
                case 3: qc.frontDequeue();
                        break;
                case 4: qc.rearDequeue();
                        break;
                // case 5: qc.display();
                //         break;
                case 6: System.exit(0);
                        break;
                default : System.out.println("Enter valid Option");
            }
        }while(choice!=4);
    }
}

class Queue_Double_Ended_Circular{
    int size,front,rear;
    int arr[];
    Scanner sc=new Scanner(System.in);
    Queue_Double_Ended_Circular(int size){
        this.size=size;
        front=-1;
        rear=-1;
        arr=new int[size];
    }

    public void frontEnqueue(){
        if((rear+1)%size==front){
            System.out.println("Queue is Full");
            return;
        }
        if(front==-1){
            front=0;
        }
        if(front==0){
            front=size-1;
        }else{
            front=(front-1)%size;
        }
        System.out.println("Enter That Element You Want Add");
        arr[front]=sc.nextInt();
    }

    public void rearEnqueue(){
        if((rear+1)%size==front){
            System.out.println("Queue is Full");
            return;
        }
        if(front==-1){
            front=0;
        }
        System.out.println("Enter Element You Want Add");
        rear=(rear+1)%size;
        arr[rear]=sc.nextInt();
        return;
    }

    public void frontDequeue(){
        if(front==-1){
            System.out.println("Queue is Empty");
            return;
        }
        int dele=arr[front];
        System.out.println(dele+" is deleted");
        if(front==rear){
            front=rear=-1;
        }else{
            front=(front+1)%size;
        }
    }

    public void rearDequeue(){
        if(front==-1){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println(arr[rear]+" Element Deleted");
        if(rear==0){
            rear=size-1;
        }else{
            rear=(rear-1)%size;
        }
    }
}