class Main{
    public static void main(String[] args) {
        DoublyLinkedList dll=new DoublyLinkedList();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addLast(6);
        dll.addLast(7);
        dll.display();
        dll.insertAfter(3, 4);
        dll.insertAfter(8, 7);
        dll.inserBetweenValues(9, 4, 3);
        dll.inserBetweenValues(10, 7, 8);
        dll.inserBetweenValues(22, 4, 6);
        // dll.deleteValue(4);
        // dll.deleteValue(10);
        System.out.println();
        dll.display();
    }
}

class DoublyLinkedList {
    Node head=null;
    class Node{
        int data;
        Node pre;
        Node next;
        Node(int data){
            this.data=data;
            this.pre=null;
            this.next=null;
        }
    }

    public void addFirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        newnode.next=head;
        head.pre=newnode;
        head=newnode;
    }

    public void addLast(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        newnode.pre=temp;
        temp.next=newnode;
    }

    public void insertBefore(int data,int target){
        if(head==null){
            System.out.println("LinkedList is Empty");
            return;
        }
        Node newnode=new Node(data);
        if(head.data==target){
            newnode.next=head;
            head.pre=newnode;
            head=newnode;
            return;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==target){
                newnode.next=temp;
                newnode.pre=temp.pre;
                temp.pre.next=newnode;
                temp.pre=newnode;
                return;
            }
            temp=temp.next;
        }
    }

    public void insertAfter(int data,int target){
        if(head==null){
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==target){
                Node newnode=new Node(data);
                newnode.next=temp.next;
                newnode.pre=temp;
                if(temp.next!=null){
                    temp.next.pre=newnode;
                }
                temp.next=newnode;
                return;
            }
            temp=temp.next;
        }
    }

    public void inserBetweenValues(int data,int left,int right){
        if(head==null||head.next==null){
            System.out.println("Insert Between Not Possible");
            return;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==left&&temp.next.data==right){
                Node newnoNode=new Node(data);
                newnoNode.next=temp.next;
                temp.next.pre=newnoNode;
                temp.next=newnoNode;
                newnoNode.pre=temp;
                return;
            }
            temp=temp.next;
        }
        System.out.println("This Pair Not Exist");
    }

    public void deleteValue(int target){
        if(head==null){
            System.out.println("LinkedList Empty");
            return;
        }
        if(head.data==target){
            head=head.next;
            return;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==target){
               temp.pre.next=temp.next;
               if(temp.next!=null){
                    temp.next.pre=temp.pre;
               }
               return;  
            }
            temp=temp.next;
        }
    }

    public boolean search(int target){
        if(head==null){
            return false;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==target){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public void reverPrint(){
        if(head==null){
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp!=null){
            System.out.println(temp.data+" ");
            temp=temp.pre;
        }
    }

    public void reverse(Node temp){
        if(temp==null){
            return;
        }
        reverse(temp.next);
        System.out.println(temp.data+ x" ");
    }

    public void display(){
        if(head==null){
            System.out.println("LinkedList is Empty");
            return;
        }
        System.out.print("null->");
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }
}