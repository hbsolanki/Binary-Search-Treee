class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;
    int size = 0;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("LinkedList is Empty ");
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        head = head.next;
        return val;
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("LinkedList is Empty ");
            return Integer.MIN_VALUE;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int val = tail.data;
        tail = temp;
        tail.next = null;
        return val;
    }

    public int nthNodeFromEnd(int n) {
        if (head == null) {
            System.out.println("LinkedList is Empty ");
            return Integer.MIN_VALUE;
        }
        //n=(size-n+1)
        Node temp = head;
        int sz = 0;
        while (temp != null) {
            sz++;
            temp = temp.next;
        }
        if (sz == n) {
            return removeFirst();
        }

        int nFirst = (sz - n );
        temp = head;
        int i = 1;
        if (i > nFirst) {
            return Integer.MIN_VALUE;
        }
        while (i < nFirst) {
            temp = temp.next;
            i++;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        return val;
    }

    public void print() {
        if (head == null) {
            System.out.println("LinkedList is Empty ");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int inteSearch(int target) {
        if (head == null) {
            System.out.println("LinkedList is Empty ");
            return -1;
        }
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == target) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public int searchRec(Node head, int target) {
        if (head == null) {
            return -1;
        }
        if (head.data == target) {
            return 0;
        }
        int val = searchRec(head.next, target);
        if (val == -1) {
            return -1;
        }
        return  val+ 1;
    }

    public int recsearch(int target) {
        return searchRec(head, target);
    }

    public boolean isPalindron(){
        Node slow=head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node curr = slow;
        Node pre = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        Node temp=head;
        while (temp != null && pre != null) {
            if (temp.data != pre.data) {
                return false;
            }
            temp = temp.next;
            pre = pre.next;
        }

        return true;
    }

    public void zigZag() {
        //find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        //reverce mid to end
        Node curr = mid.next;
        mid.next = null;
        Node pre = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        Node left = head;
        Node right = pre;
        Node nextL, nextR;
        //alt merge- zigzag
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.print();
        // // ll.addFirst(2);
        // ll.addLast(0);
        // ll.addLast(2);
        // ll.print();
        // System.out.println(ll.isPalindron());
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.print();
        ll.zigZag();
        ll.print();
    }
}
