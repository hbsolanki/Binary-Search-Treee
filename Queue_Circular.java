import java.util.*;

class Queue_Circular_Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enrer Queue Size");
        Queue_Circular qc=new Queue_Circular(sc.nextInt());
        int choice;
        do{
            System.out.println("Enter Number For (1)enqueue (2)dequeue (3)display (4)Exit");
            choice=sc.nextInt();
            switch(choice){
                case 1: qc.enqueue();
                        break;
                case 2: qc.dequeue();
                        break;
                case 3: qc.display();
                        break;
                case 4:System.exit(0);
                        break;
                default : System.out.println("Enter valid Option");
            }
        }while(choice!=4);
    }
}

class Queue_Circular{
    int size,front,rear;
    int arr[];
    Scanner sc=new Scanner(System.in);
    Queue_Circular(int size){
        this.size=size;
        front=-1;
        rear=-1;
        arr=new int[size];
    }

    public void enqueue(){
        if((rear+1)%size==front){
            System.out.println("OverFlow");
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

    public void dequeue(){
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

    public void display(){
        System.out.println("Front: "+front+" Rear: "+rear);
        System.out.println("Queue is: ");
        int i=0;
        for(i=front;i!=rear;i=(i+1)%size){
            System.out.println(arr[i]);
        }
        System.out.println(arr[i]);
    }
}