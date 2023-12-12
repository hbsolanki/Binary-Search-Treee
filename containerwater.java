import java.util.*;

class Container {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);
        System.out.println(containerWater(list));
        System.out.println(storeWater(list));
    }
    

    //brute Force Approach
    public static int containerWater(ArrayList<Integer> height) {
        int maxWater = 0;

        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wt = j - i;
                int currWater = ht * wt;
                maxWater = Math.max(maxWater, currWater);
            }
        }

        return maxWater;
    }
    
    //2 pointer
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;

        int lp = 0;
        int rp=height.size()-1;
        while(lp<rp){
            int ht = Math.min(height.get(rp), height.get(lp));
            int wt = rp - lp;
            int currWater = ht * wt;
            maxWater = Math.max(maxWater, currWater);
            if (height.get(rp) > height.get(lp)) {
                lp++;
            } else {
                rp--;
            }
        }

        return maxWater;
    }
}