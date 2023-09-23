class CircularLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public void addLast(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            newnode.next = newnode;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.next = head;
    }

    public static Node createLoop(){
        Node node=new Node(1);
        node.next=new Node(2);
        node.next.next=new Node(3);
        node.next.next.next=new Node(4);
        node.next.next.next.next=node.next;

        return node;
    }

    public static void findLoop(Node head){
        if(head==null || head.next==null){
            return;
        }
        Node slow=head;
        Node fast=head;

        do{
            slow=slow.next;
            fast=fast.next.next;
            if((slow==fast) && (fast!=head)){
                System.out.println("Loop is Exist");
                break;
            }
            if((slow==fast) && (fast==head)){
                System.out.println("ONLY MAIN Loop is Exist");
            }
        }while(slow!=head);
    }

    public static Node removeLoop(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node slow=head;
        Node fast=head;

        do{
            slow=slow.next;
            fast=fast.next.next;
            if((slow==fast.next) && (fast!=head)){
                fast.next=head;
                System.out.println("Loop is Exist");
                break;
            }
            if((slow==fast) && (fast==head)){
                System.out.println("ONLY MAIN Loop is Exist");
            }
        }while(slow!=head);
        return head;
    }

}

class CLLMain {
    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        cl.addLast(2);
        cl.addLast(2);
        cl.addLast(2);
        CircularLinkedList.findLoop(cl.head);
        CircularLinkedList.findLoop(CircularLinkedList.createLoop());
        CircularLinkedList.findLoop(CircularLinkedList.removeLoop(CircularLinkedList.createLoop()));
    }
}
