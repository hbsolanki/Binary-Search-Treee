
class LinearSearch {

    public static int linearSearch(int arr[],int key){ //O(n)
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }

    //sorted Array   //binarySearch->Divide And Conquer
    public static int binarySearch(int arr[], int key) { //O(log(n))
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                start = mid + 1;
            } else { //mid>key
                end = mid - 1;
            }
        }
        return -1;
    }
    
    public static void findMinMax(int arr[]) {  //O(n)
        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min_value) {
                min_value = arr[i];
            }
            if (arr[i] > max_value) {
                max_value = arr[i];
            }
        }

        System.out.println("Min Value : " + min_value + " Max Value  :" + max_value);
    }
    
    public static void printPair(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            for (int k = i + 1; k < arr.length; k++) {
                System.out.print("( " + curr + " , " + arr[k] + " )");
            }
            System.out.println();
        }
    }

    public static void printSubArray(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    sum += arr[k];

                    if (arr[k] > max) {
                        max = arr[k];
                    }

                    if (arr[k] < min) {
                        min = arr[k];
                    }
                }
                System.out.println();
                System.out.println("sum : " + sum + " Min : " + min + " Max : " + max);
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
            System.out.println();
        }
        System.out.println("Maximum Sum : " + maxSum);
    }
    

    public static void maxSumOfSubArrayPrefix(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];

        //calculate Prefix Array
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] * arr[i];
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
            }
            if (maxSum < currSum) {
                maxSum = currSum;
            }
        }

        System.out.println("Max Sum : " + maxSum);
    }
    
    public static void maxSumOfSubArrayKadanes(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum < 0) {
                currSum = 0;
            }

            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println("MaxSum : " + maxSum);
    }
    

    //traping rainwater
    public static int trapingRainwater(int height[]) {
        int n = height.length;
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }

        //calculate Left Max
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        //calculate Right Max
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int waterTrap = 0;
        //loop
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(rightMax[i], leftMax[i]);

            waterTrap += waterLevel - height[i];
        }
        return waterTrap;
    }
    
    public static int buyAndSellStock(int prices[]) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int currPrice = prices[i];

            if (currPrice > buyPrice) {
                int profit = currPrice - buyPrice; //today's Profit

                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = currPrice;
            }
        }
        return maxProfit;
    }

    public static int stoke(int arr[]) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int currPrice = arr[i];
            if (currPrice > buyPrice) {
                int profit = currPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = currPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trapingRainwater(height));
        int[] prices = {7,1,9,5,0};
        System.out.println(buyAndSellStock(prices));
        System.out.println(stoke(prices));
    }
}