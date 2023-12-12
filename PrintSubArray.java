public class PrintSubArray {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 7, 9 };
        printSubArray(arr);
        findMaxSum(arr);
        findMaxSumPrefix(arr);
        kadanesAlgo(arr);
    }
    
    public static void printSubArray(int arr[]) { //O(n^3)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void findMaxSum(int arr[]) { //O(n^3)
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currentSum = 0;
                for (int k = i; k <= j; k++) {
                    currentSum += arr[k];
                }
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        System.out.println("Max Sum :  " + maxSum);
    }
    
    public static void findMaxSumPrefix(int arr[]) { //O(n^2)
        int n = arr.length;
        if (n == 0) {
            return;
        }
        //Finding Prefix Sum
        int prefix[] = new int[n];

        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                int currentSum = 0;
                currentSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        System.out.println("Max Sum : " + maxSum);
    }
    
    public static void kadanesAlgo(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println("Max Sum : " + maxSum);
    }
}
