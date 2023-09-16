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

    public void newHead(Node h3) {
        this.head = h3;
    }

    public void addFirst(int data) {
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
        head = newnode;
    }

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

    public void display() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println(temp.data + ":CLL");
    }

    public void deleteFront() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        head = head.next;
        temp.next = head;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        temp.next = head;
    }

    public void insertBefore(int data, int target) {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node newnode = new Node(data);
        if (head.data == target) {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newnode.next = head;
            head = newnode;
            temp.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            if (temp.next.data == target) {
                newnode.next = temp.next;
                temp.next = newnode;
                return;
            }
            temp = temp.next;
        }
        System.out.println(target + " is not in LinkedList");
    }

    public void inserBetweenValue(int data, int left, int right) {
        if (head == null && head.next == head) {
            System.out.println("InserBetween Not Possible");
            return;
        }
        Node temp = head;
        do {
            if (temp.data == left && temp.next.data == right) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("This value Pair Not is Available");
    }

    public void insertAfter(int data, int target) {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }

        Node temp = head;
        do {
            if (temp.data == target) {
                Node newnode = new Node(data);
                newnode.next = temp.next;
                temp.next = newnode;
                return;
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void deleteValue(int target) {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        if (head.data == target) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.next.data == target) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println("This " + target + " Value not Exist");
    }

    public Node fun(Node L1, Node L2) {
        if (L1 == null && L2 == null) {
            return null;
        }
        if (L1 == null) {
            return L2;
        }
        if (L2 == null) {
            return L1;
        }

        Node L3 = L1;
        Node temp1 = L1;
        Node temp2 = L2;

        do {
            temp1.data += temp2.data;
            if (temp1.next == L1) {
                temp1.next = temp2.next;
                return temp1;
            }
            if (temp2.next == L2) {
                return temp1;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        } while (temp1.next == L1 || temp2.next == L2);
        return temp1;
    }
}

class CLLMain {
    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        cl.addFirst(2);

        cl.addLast(4);
        cl.addLast(6);
        cl.addLast(7);
        cl.addLast(9);
        cl.display();

        CircularLinkedList cl2 = new CircularLinkedList();
        cl2.addFirst(5);

        cl2.addLast(3);
        cl2.addLast(12);
        cl2.addLast(11);
        cl2.addLast(45);
        cl2.display();
        CircularLinkedList.Node L3 = cl.fun(cl.head, cl2.head);
        System.out.println();
        CircularLinkedList cl3 = new CircularLinkedList();
        cl3.newHead(L3);
        cl3.display();
    }
}