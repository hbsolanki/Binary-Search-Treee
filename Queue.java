import java.util.*;

class Queue_Oprations{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Queue Size");
        MyQueue q=new MyQueue(sc.nextInt());
        int choice;
        do{
            System.out.println("Enter Number For (1)enqueue (2)dequeue (3)display (4)Exit");
            choice=sc.nextInt();
            switch(choice){
                case 1: q.enqueue();
                        break;
                case 2: q.dequeue();
                        break;
                case 3: q.display();
                        break;
                case 4:System.exit(0);
                        break;
                default : System.out.println("Enter valid Option");
            }

        }while(choice!=4);
    }
}

class MyQueue{
    Scanner sc=new Scanner(System.in);
    int arr[];
    int size,front,rear;
    MyQueue(int size){
        arr=new int[size];
        this.size=size;
        front=-1;
        rear=-1;
    }

    public void enqueue(){
        if(rear+1>=size){
            System.out.println("OverFlow");
            return;
        }
        System.out.print("Enter Element That You Want insert : ");
        arr[++rear]=sc.nextInt();
        if(front==-1){
            front=0;
        }
        return;
    }

    public void dequeue(){
        if(rear==-1){
            System.out.println("UnderFlow");
            return;
        }
        System.out.println(arr[front]+"Element Deleted");
        if(front==rear){
            front=-1;
            rear=-1;
        }else{
            front++;
        }
    }

    public void display(){
        if(front==-1){
            System.out.println("Queue is emplty");
            return;
        }
        System.out.println("Front: "+front+"Rear: "+rear);
        System.out.println("Queue is: ");
        for(int i=front;i<=rear;i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }
}