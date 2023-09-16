class Tries{
    static class Node{
        Node children[]=new Node[26];
        boolean eow;

        public Node(){
           for(int i=0;i<26;i++){
                children[i]=null;
           } 
        }
    }

    public  Node root=new Node();

    public void insert(String word){
        Node temp=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(temp.children[idx]==null){
                temp.children[idx]=new Node();
            }
            temp=temp.children[idx];
        }
        temp.eow=true;
    }

    public boolean search(String word){
        Node temp=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(temp.children[idx]==null){
                return false;
            }
            temp=temp.children[idx];
        }
        return temp.eow==true;
    }

    public static void main(String[] args) {
        Tries th=new Tries();
        th.insert("th");
        th.insert("there");
        th.insert("apple");
        System.out.println(th.search("th"));
        System.out.println(th.search("there"));
        System.out.println(th.search("banana"));
        System.out.println(th.search("applee"));
        System.out.println(th.search("apple"));
        
    }
}   
