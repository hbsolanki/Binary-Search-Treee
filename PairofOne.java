import java.util.ArrayList;
class PairofOne {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // System.out.println(pairofOne(list, 50));
        // System.out.println(pairSumeOne(list, 5));
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(pairSumTwo(list,26));
    }
   
    //bruteFource
    public static boolean pairofOne(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //two pointer
    public static boolean pairSumeOne(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size() - 1;

        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }

        return false;
    }

    public static int pivit(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean pairSumTwo(ArrayList<Integer> list, int target) {
        int n = list.size();
        int pivit=pivit(list);
        int rp=pivit;
        int lp=pivit+1;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp=(lp+1)%n;
            } else {
                rp=(rp+n-1)%n;
            }
        }
        return false;
    }
}
