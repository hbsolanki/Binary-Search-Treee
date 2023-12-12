class FindSubSet {
    public static void subSet(String str, String ans, int i) {
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        subSet(str, ans + str.charAt(i), i + 1);
        subSet(str, ans, i + 1);
    }
    
    public static void main(String[] args) {
        printSub("ABC", "", 0);
        subSet("ABC", "", 0);
    }

    public static void printSub(String str,String ans,int i) {
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        printSub(str, ans + str.charAt(i), i + 1);
        printSub(str, ans, i+1);
    }
}
