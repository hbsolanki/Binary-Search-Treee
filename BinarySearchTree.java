import java.util.ArrayList;

class BST{
   static Node root;
    public static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data=data;
        }
    }

    static int idx=0;
    public static Node createBST(int []arr){
        if(root==null){
            Node curr=new Node(arr[idx]);
            idx++;
            return curr;
        }
        if(arr[idx]<root.data){
           root.left=createBST(arr);
        }else{
           root.right=createBST(arr);
        }
        return root;
    }

    public static Node buildTree(int data,Node root){
        if(root==null){
            return new Node(data);
        }
        if(data<root.data){
            root.left=buildTree(data, root.left);
        }else{
            root.right=buildTree(data, root.right);
        }
        return root;
    }

    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(key<root.data){
            search(root.left, key);
        }else if(root.data==key){
            return true;
        }else{
            search(root.right, key);
        }
        return false;
    }

    public static Node delete(Node root,int val){
        if(root==null){
            return null;
        }
        if(val<root.data){
            root.left=delete(root.left, val);
        }
        if(val>root.data){
            root.right=delete(root.right, val);
        }else{
            //case 1
            if(root.right==null&&root.left==null){
                return null;
            }
            //case 2
            if(root.right==null){
                return root.left;
            }
            if(root.left==null){
                return root.right;
            }

            //case3
            if(root.right!=null&&root.left!=null){
                return root;
            }
        }
        
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    public static void printBetween(Node root,int x,int y){
        if(root==null){
            return;
        }
        if(root.data>=x&&root.data<=y){
            printBetween(root.left, x, y);
            System.out.println(root.data+" ");
            printBetween(root.right, x, y);
            return;
        }
        if(x>root.data){
            printBetween(root.right, x, y);
        }else if(y<root.data){
            printBetween(root.left, x, y);
        }
    }

    public static void printPath(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }

        path.add(root.data);

        //leaf
        if(root.left== null && root.right== null){
            print(path);
        }else{  //non-leaf
            printPath(root.left, path);
            printPath(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public static void print(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }

    public static void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        System.out.print(root.data+ " ");
        display(root.right);
    }

    public static void main(String[] args) {
        int arr[]={5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<arr.length;i++){
            root=buildTree(arr[i], root);
        }
        display(root);
        System.out.println();
        System.out.println(search(root, 5));
        System.out.println(search(root, 9));
        // delete(root, 4);
        display(root);
        System.out.println();
        // printBetween(root, 3, 7);
        printPath(root, new ArrayList<>());
    }
}