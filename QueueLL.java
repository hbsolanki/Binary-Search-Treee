class QueueLL{
    Node head;
    Node tail;

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    public void enqueue(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }

    public void dequeue(){
        if(head==null){
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println(head.data+" is deleted");
        head=head.next;
    }

    public void display(){
         if(head==null){
            System.out.println("Queue is Empty");
            return;
        }
        Node temp=head;
        System.out.println("Queue is : ");
        while(temp!=null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        QueueLL ql=new QueueLL();
        ql.enqueue(11);
        ql.enqueue(22);
        ql.dequeue();
        ql.display();
    }
}
