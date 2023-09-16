import java.util.*;

public class BST{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    //Insertions
    public static Node insert(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }

        if(root.data>data){
            //left SubTree
            root.left=insert(root.left,data);
        }else{
            root.right=insert(root.right, data);
        }
        return root;
    }

    //Traversals
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                System.out.println();
                //Queue Empty
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }

    //Search
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left, key);
        }
        if(root.data<key){
            return search(root.right, key);
        }
        return false;
    }

    //Delete
    public static Node delete(Node root,int val){
        if(root.data>val){
            root.left=delete(root.left,val);
        }else if(root.data<val){
            root.right=delete(root.right, val);
        }else{
            //root.data==val
            
            //case:1
            if(root.left==null && root.right==null){
                return null;
            }
            //case:2
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            //case:3
            Node IS=inOrderSuccessor(root.right);
            delete(root,IS.data);
            root.data=IS.data;
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }

    //Count Of Nodes
    public static int countOfNodes(Node root){
        if(root==null){
            return 0;
        }
        return countOfNodes(root.left)+countOfNodes(root.right)+1;
    }

    //Height Of A Tree
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }

    //Diameter O(N^2)

    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int diam1=height(root.left)+height(root.right)+1;
        int diam2=diameter(root.left);
        int diam3=diameter(root.right);

        return Math.max(diam1, Math.max(diam2, diam3));
    }
    
    //Sum Of Nodes Of Tree
    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        return sumOfNodes(root.left)+sumOfNodes(root.right)+root.data;
    }

    //Print in Range
    public static void printInRange(Node root,int x,int y){
        if(root==null){
            return;
        }
        if(root.data>=x && root.data<=y){
            printInRange(root.left, x, y);
            System.out.print(root.data+" ");
            printInRange(root.right, x, y);
        }else if(root.data>=y){
            printInRange(root.left, x, y);
        }else{
            printInRange(root.right, x, y);
        }
    }

    //Root To Leaf Paths
    public static void printRoot2Leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);

        //leaf
        if(root.left==null && root.right==null){
            printPath(path);
        }else{
            //Non-leaf
            printRoot2Leaf(root.left,path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            if(i==path.size()-1){
                System.out.print(path.get(i));
                break;
            }
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }    

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int values[]={5,1,3,4,2,7};
        Node root=null;

        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }

        int choice;
        do{
            System.out.println();
            System.out.println("1.Traversals\n2.Search\n3.Delete\n4.Count Of Nodes \n5.Height\n6.Diameter\n7.Sum Of Nodes\n8.Print Range Two Number\n9.Root To Leaf Paths\n10.Exit");
            System.out.print("Select Options : ");
            choice=sc.nextInt();
            System.out.println();
            switch(choice){
                case 1 : traversals(sc,root);
                         break;
                case 2 : System.out.print("Enter Value That You Want To Search :");
                         if(search(root, sc.nextInt())){
                            System.out.println("Value is Exist");
                         }else{
                            System.out.println("Value Not Exist");
                         }
                         break;
                case 3 : System.out.print("Enter Value That You Want To Delete :");
                         int dele=sc.nextInt();
                         if(search(root, dele)){
                            delete(root,dele);
                            System.out.println(dele+ " is Deleted");
                         }else {
                            System.out.println(dele+" is not exist in Tree So Can't Delete");
                         }
                         break;
                case 4 : System.out.println("Total Nodes is : "+countOfNodes(root));;
                         break;
                case 5 : System.out.println("Height of Tree is : "+height(root));
                         break;
                case 6 : System.out.println("Diammeter of Tree is : "+diameter(root));
                         break;
                case 7 : System.out.println("Sum of All Nodes value is : "+sumOfNodes(root));
                         break;
                case 8 : System.out.print("Enter Two Number : ");
                         int a=sc.nextInt();
                         int b=sc.nextInt();
                         printInRange(root, a, b);
                         break; 
                case 9 : ArrayList<Integer> path=new ArrayList<>();
                         printRoot2Leaf(root,path); 
                         break;
                case 10 : System.exit(-1);
                         break;
                default : System.out.println("Enter Valid Option");                                  
            }

        }while(choice!=10);
    }

    public static void traversals(Scanner sc,Node root){
        System.out.println();
        System.out.println("(1)PreOrder (2)InOrder (3)PostOrder (4)LevelOrder");
        int choice=sc.nextInt();
        System.out.println();
        switch(choice){
            case 1 : preOrder(root);
                     break;
            case 2 : inOrder(root);
                     break;
            case 3 : postOrder(root);
                     break;
            case 4 : levelOrder(root);
                     break;
            default : System.out.println("Enter valid Choice");
                     break;
        }
        System.out.println();
    }
}