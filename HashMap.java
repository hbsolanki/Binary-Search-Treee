import java.util.ArrayList;
import java.util.LinkedList;

class HashSet{
    static class HashMap<K,V>{    //generics
        private class Node{
            K key;
            V value;
            Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }
        private int n=0;     // nodes of LinkedList
        private int N;    //bucket
        LinkedList<Node> buckets[];  //declare Array Of LinkedList
        HashMap(){
            this.N=4;
            buckets=new LinkedList[N];
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<>();
            }
        }

        public int hashFunction(K key){
            int bi=key.hashCode();
            return Math.abs(bi)%N;
        }

        public int searchInLL(int bi,K key){
            LinkedList<Node> node=buckets[bi];
            for(int i=0;i<node.size();i++){
                if(node.get(i).key==key){
                    return i;
                }
            }
            return -1;
        }

        private void rehashing() {
            LinkedList<Node> oldbuckets[]=buckets;
            LinkedList<Node>[] buckets=new LinkedList[N*2];
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList();
            }
            for(int i=0;i<oldbuckets.length;i++){
                LinkedList<Node> ll=oldbuckets[i];
                for(int k=0;k<ll.size();i++){
                    Node getNode=ll.get(k);
                    put(getNode.key, getNode.value);
                }
            }
        }

        public void put(K key,V value){
            int bi=hashFunction(key);
            int di=searchInLL(bi, key);

            if(di==-1){
                buckets[bi].add(new Node(key, value));
                n++;
            }else{
                buckets[bi].get(di).value=value;
            }

            double lambda=(double)n/N;
            if(lambda>2.0){
                rehashing();
            }
        }

        public V remove(K key){
            int bi=hashFunction(key);
            int di=searchInLL(bi, key);
            if(di==-1){          //key Does Not Exist
                return null;
            }else{              ////key Exist
                Node node=buckets[bi].remove(di);     //in buckets bi index's LL remove Node with indext di, di=key index in LL
                n--;
                return node.value;
            }
        }

        public V get(K key){
            int bi=hashFunction(key);
            int di=searchInLL(bi, key);
            if(di==-1){        //key Does Not Exist
                return null;
            }else {           //key Exist
                Node node=buckets[bi].get(di);  //in buckets bi index's LL  with indext di, di=key index(Node) in LL
                return node.value;
            }
        }

        public boolean containsKey(K key){
            int bi=hashFunction(key);
            int di=searchInLL(bi, key);
            if(di==-1){     //key Does Not Exist
                return false;
            } else {       //key Exist
                return true;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> list=new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll=buckets[i];
                for(int k=0;k<ll.size();k++){
                    list.add(ll.get(k).key);
                }
            }
            return list;
        }
    }

    //Main Method
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);

        ArrayList al=map.keySet();
        System.out.println(al);

        map.remove("China");
        System.out.println(map.containsKey("China"));
        System.out.println(map.get("India"));
    }
}