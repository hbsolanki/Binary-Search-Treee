import java.util.*;

class BasicSorting {
    public static void main(String[] args) {
        int num[] = { 5, 1, 3, 2, 4 };
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+" ");
        }
    }
    
    public static void bubbleSorting(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //swap
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[pos] > arr[j]) {
                    pos = j;
                }
            }

            //swap
            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
        }
    }  
    
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int pre = i - 1;

            while (pre >= 0 && arr[pre] > curr) {
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = curr;
        }
    }

    public static void countingSort(int arr[]) {
        int max = Integer.MIN_VALUE;
        //finding max Value
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        //store Frequency
        int count[] = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[idx] = i;
                idx++;
                count[i]--;
            }
        }
    }

}
