import java.util.*;

class Binary_Tree {
    public static class Node{
        int data;
        Node leftNode;
        Node rightNode;
        Node(int data){
            this.data=data;
            leftNode=null;
            rightNode=null;
        }
    }
    public static class createTree{
        static int idx=-1;
        public static Node binaryTree(int []node){
            idx++;
            if(node[idx]==-1){
                return null;
            }
            Node newnode=new Node(node [idx]);
            newnode.leftNode=binaryTree(node);
            newnode.rightNode=binaryTree(node);
            return newnode;
        }
    }

    public static void print(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data+" ");
        print(root.leftNode);
        print(root.rightNode);
    }

    public static void preOrder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.data+" ");
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }

    public static void inOrder(Node root){
        if(root == null){
            return ;
        }
        preOrder(root.leftNode);
        System.out.print(root.data+" ");
        preOrder(root.rightNode);
    }

    public static void postOrder(Node root){
        if(root == null){
            return ;
        }
        preOrder(root.leftNode);
        preOrder(root.rightNode);
        System.out.print(root.data+" ");
    }

    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node temp=q.remove();
            if(temp==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(temp.data+" ");

                //add left Node on Queue
                if(temp.leftNode!=null){
                    q.add(temp.leftNode);
                }

                //add right Node on Queue
                if(temp.rightNode!=null){
                    q.add(temp.rightNode);
                }
            }
        }
    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.leftNode), height(root.rightNode)) +1;
    }

    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        return countNode(root.leftNode)+countNode(root.rightNode)+1;
    }

    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.leftNode)+height(root.rightNode)+1,Math.max(diameter(root.leftNode),diameter(root.rightNode)));
    }

    static class TreeInfo{
        int ht;
        int dia;
        TreeInfo(int ht,int dia){
            this.ht=ht;
            this.dia=dia;
        }
    }

    public static TreeInfo diameter2(Node root){
        if(root==null){
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTI=diameter2(root.leftNode);
        TreeInfo rightTI=diameter2(root.rightNode);

        int myHeight=Math.max(leftTI.ht,rightTI.ht)+1;

        int dia1=Math.max(leftTI.dia, rightTI.dia);
        int dia2=leftTI.ht+rightTI.ht+1;
        int dia3=Math.max(dia1,dia2);

        return new TreeInfo(myHeight, dia3);
    }

    public static int sumOfNode(Node root){
        if(root==null){
            return 0;
        }
        return sumOfNode(root.leftNode)+ sumOfNode(root.rightNode)+ root.data;
    }

    public static boolean isIdentical(Node root,Node subTree){
        if(root==null&&subTree==null){
            return true;
        }
        if(root==null||subTree==null){
            return false;
        }
        if(root.data==subTree.data){
            return isIdentical(root.leftNode, subTree.leftNode)&&isIdentical(root.rightNode, subTree.rightNode);
        }
        return false;
    }


    public static boolean isSubTree(Node root,Node subTree){
        if(subTree==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(isIdentical(root, subTree)){
            return true;
        }
        return isSubTree(root.leftNode, subTree)|| isSubTree(root.rightNode, subTree);
    }
    
    public static void main(String[] args) {
        int []nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary_Tree tree=new Binary_Tree();
        Node root=createTree.binaryTree(nodes);
        System.out.println("First Node : "+root.data);
        // print(root);
        System.out.println("Heigth of Tree : "+height(root));
        System.out.println("Total Node in Tree : "+ countNode(root));
        System.out.println("Sum Of Node Data : "+ sumOfNode(root));
        System.out.println("Leval Order");
        levelOrder(root);
        System.out.println("Diameter is : "+ diameter(root));
        System.out.println("Diameter2 is : "+ diameter2(root).dia);
        postOrder(root);
        
    }
}