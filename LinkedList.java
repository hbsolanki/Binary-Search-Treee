class Main {
    public static void main(String args[]) {
        LList l = new LList();
        l.addFirst(10);
        l.addLast(20);
        l.display();
        l.deleteFirst();
        l.deleteLast();
        l.addFirst(44);
        l.display();
        l.insertBefore(33, 44);
        l.display();
        l.insertBefore(36, 44);
        l.insertAfter(40, 36);
        l.insertBetween(36,36 ,40);
        l.DeleteNode(44);
        // l.DeleteNode(36);
        // l.insertBeforeAll(366, 36);
        l.display();
    }
}

class LList {
    Node front;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void addFirst(int data) {
        Node newnode = new Node(data);
        if (front == null) {
            front = newnode;
            return;
        }
        newnode.next = front;
        front = newnode;
    }

    public void addLast(int data) {
        Node newnode = new Node(data);
        if (front == null) {
            front = newnode;
            return;
        }
        Node temp = front;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
    }

    public void deleteFirst() {
        if (front == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        System.out.println(front.data + " is deleted");
        front = front.next;
    }

    public void deleteLast() {
        if (front == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        if (front.next == null) {
            System.out.println(front.data + " is deleted");
            front = null;
            return;
        }
        Node temp = front;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println(temp.next.data + " is deleted");
        temp.next = null;
    }

    public void insertBefore(int data,int target){
        if(front==null){
            System.out.println("LinkedList is Empty");
            return;
        }
        Node newnode=new Node(data);
        if(front.data==target){
          newnode.next=front;
          front=newnode;
          return;  
        }

        Node temp=front;
        while(temp.next!=null){
            if(temp.next.data==target){
                newnode.next=temp.next;
                temp.next=newnode;
                break;
            }
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Target Value Not Found");
        }
    }

    public void insertAfter(int data,int target){
        if(front==null){
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp=front;
        while(temp!=null){
            if(temp.data==target){
                Node newnode=new Node(data);
                newnode.next=temp.next;
                temp.next=newnode;
                break;
            }
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Target Value Not Found");
        }
    }

    public void insertBetween(int data,int aTarget,int bTerget){
        if(front==null){
            System.out.println("LinkedList is Empty");
            return;
        }
        if(front.next==null){
        System.out.println("Only One Node In LinkedList");
          return;  
        }

        Node temp=front;
        int cnt=0;
        while(temp.next!=null){
            if(temp.data==aTarget&&temp.next.data==bTerget){
                Node newnode=new Node(data);
                newnode.next=temp.next;
                temp.next=newnode;
                cnt++;
                break;
            }
            temp=temp.next;
        }
        if(cnt==0){
            System.out.println("Target Value Not Found");
        }
    }

    public void insertBeforeAll(int data,int target){
        if(front==null){
            System.out.println("LinkedList is Empty");
            return;
        }
        Node newnode=new Node(data);
        if(front.data==target){
          newnode.next=front;
          front=newnode;
          return;  
        }

        Node temp=front;
        int cnt=0;
        while(temp.next!=null){
            if(temp.next.data==target){
                newnode.next=temp.next;
                temp.next=newnode;
                cnt++;
            }
            temp=temp.next;
        }
        if(cnt==0){
            System.out.println("Target Value Not Found");
        }
    }

    public void DeleteNode(int target){
        if(front==null){
            System.out.println("LinkedList is Empty");
            return;
        }

        Node temp=front;
        while(temp.next!=null){
            if(temp.next.data==target){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Target Value Not Found");
        }
    }

    public void deleteDuplicateValue(){
        if(front==null){
            System.out.println("Linked List is Empty");
            return;
        }
        HashSet<Integer> set=new HashSet<>();
        Node temp=front;
        while(temp!=null){
            set.add(temp.data);
            temp=temp.next;
        }
        front=null;
        for(int data : set){
            addFirst(data);
        }
    }

    public void deleteEvenValue(){
        if(front==null){
            return;
        }

        while(front!=null && front.data%2==0){
            front=front.next;
        }

        Node temp=front;
        Node pre=null;

        while(temp!=null){
            if(temp.data%2==0){
                pre.next=temp.next;
            }else{
                pre=temp;
            }
            temp=temp.next;
        }
    }

    public void deleteODDValue(){
        if(front==null){
            return;
        }

        while(front!=null && front.data%2!=0){
            front=front.next;
        }

        Node temp=front;
        Node pre=null;

        while(temp!=null){
            if(temp.data%2!=0){
                pre.next=temp.next;
            }else{
                pre=temp;
            }
            temp=temp.next;
        }
    }

    public void deleteEVENPosition(){
        if(front==null){
            return;
        }
        
        Node temp=front;
        while(temp!=null){
            if(temp.next!=null){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }

    }

    public void deleteODDPosition(){
        if(front==null){
            return;
        }
        front=front.next;
        if(front==null){
            return;
        }
        
        Node temp=front;
        while(temp!=null){
            if(temp.next!=null){
                temp.next=temp.next.next;
            }
            temp=temp.next;
        }

    }

    public void display() {
        if (front == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = front;
        System.out.println("LinkedList is : ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
