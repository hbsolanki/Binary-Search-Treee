class LL{
    static Node head;
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    public void firstAdd(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }

    public void lastAdd(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }

        Node curr=head;
        while(curr!=null){
            curr=curr.next;
        }
        curr=newnode;
    }
    public void DeleteFirst(){
        if(head==null){
            System.out.println("LinkedList is Empty");
            return;
        }
        head=head.next;
    }

    public void deleteLast(){
        if(head==null){
            System.out.println("Empty LinkedList");
            return;
        }
        if(head.next==null){
            return;
        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr=null;
    }

    public void display(){
        if(head==null){
            System.out.println("LinkedList is empty");
            return;
        }
        Node curr=head;
        System.out.println("LinkedList is: ");
        while(curr!=null){
            System.out.println(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }

    public void reverseList(){
        if(head==null||head.next==null){
            return;
        }
        Node pre=head;
        Node curr=head.next;
        while(curr!=null){
            Node nex=curr.next;
            curr.next=pre;
            pre=curr;
            curr=nex;
        }
        head.next=null;
        head=pre;
    }

}

class LLMain{
    public static void main(String[] args) {
        LL l=new LL();
        l.firstAdd(4);
        l.lastAdd(5);
        l.display();
        l.firstAdd(3);
        l.lastAdd(7);
        l.display();
        l.reverseList();
        l.display();
    }
}