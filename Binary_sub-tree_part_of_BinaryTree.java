class Tree{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx=-1;
        public static Node createTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=createTree(nodes);
            newNode.right=createTree(nodes);
            return newNode;
        }
    }

    public static boolean isSubTree(Node root,Node subRoot){
        if(subRoot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(isIdentical(root, subRoot)){
            return true;
        }
        return isSubTree(root.left, subRoot) || isIdentical(root.right, subRoot);
    }

    public static boolean isIdentical(Node root,Node subRoot){
        if(subRoot==null && root==null){
            return true;
        }
        if(root==null || subRoot==null){
            return false;
        }

        if(root.data==subRoot.data){
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }

    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        
        System.out.print(root.data+" ");
        inOrder(root.left);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int []nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree1=new BinaryTree();
        Node root1=tree1.createTree(nodes);
        inOrder(root1);
        System.out.println();

        BinaryTree.idx=-1;
        int []sub={2,4,-1,-1,5,-1,-1};
        BinaryTree tree2=new BinaryTree();
        Node root2=tree2.createTree(sub);
        inOrder(root2);
        System.out.println();
        System.out.println(isSubTree(root1, root2));
    }

}