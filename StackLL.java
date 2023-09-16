class StackLL{
    static Node head;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    public void push(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }

    public static int pop(){
        if(head==null){
            System.out.println("Stack is Empty");
            return -1;
        }
        int dele=head.data;
        head=head.next;
        return dele;
    }

    public static void display(){
        if(head==null){
            System.out.println("Stack is Empty");
            return ;
        }
        Node temp=head;
        System.out.println("Stack is : ");
        while(temp.next!=null){
            System.out.println(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackLL sl=new StackLL();
        sl.push(4);
        System.out.println(sl.pop());
        display();
    }
}