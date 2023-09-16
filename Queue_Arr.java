class Queue_Oprations{
    int size,rear;
    int arr[];
    Queue_Oprations(int size){
        rear=-1;
        arr=new int[size];
        this.size=size;
    }

    public boolean isEmpty(){
        return rear==-1;
    }

    public boolean isFull(){
        return rear+1==size;
    }

    public void add(int data){
        if(isFull()){
            System.out.println("Over Flow");
            return;
        }
        rear++;
        arr[rear]=data;
        return;
    }

    public int delete(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }
        int dele=arr[rear];
        rear--;
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        return dele;
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return;
        }
        System.out.println(arr[0]);
        return;
    }
}

class QR_Main{
    public static void main(String args[]){
        Queue_Oprations q=new Queue_Oprations(4);
        q.add(2);
        q.peek();
        q.delete();
        // q.add(8);
        q.peek();

    }
}