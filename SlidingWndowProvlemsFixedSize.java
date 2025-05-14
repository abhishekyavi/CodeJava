package CodeJava;

import java.util.HashSet;

public class SlidingWndowProvlemsFixedSize {
    public static void main(String[] args) {
        // maxSubArry();
        // noOfEvenNumbers();
        // avgOfEachSubArray();
        // countTheOdds();
        // counZeros();
        // newSlidingStyle();
        // countUnqueInEveryWindow();
        // countDistictElements();
        checkIfAllElemetsUnique();

    }

    // Find the maximum sum of any subarray of size k=3

    private static void maxSubArry() {
        int[] arr = { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        int maxsum = 0;
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum = windowSum + arr[i];
        }
        maxsum = windowSum;
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            maxsum = Math.max(maxsum, windowSum);

        }
        System.out.println(maxsum);

    }

    // Count of Even Numbers in Every Window of Size K=3; output: 2 1 1 2
    private static void noOfEvenNumbers() {
        int[] arr = { 2, 4, 1, 3, 6, 8 };
        int k = 3;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        System.out.print(count + " ");
        for (int i = k; i < arr.length; i++) {
            // If the element leaving the window was even, decrease count.
            if (arr[i - k] % 2 == 0)
                count--;

            // If the new element entering the window is even, increase count.
            if (arr[i] % 2 == 0)
                count++;

            System.out.print(count + " ");
        }

    }

    // Given an array and a number k, print the average of each subarray of size k.
    // output : 2.2 2.8 2.4 3.6 2.8
    private static void avgOfEachSubArray() {
        int[] arr = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
        int k = 5;
        // avg of the 1st window

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum = windowSum + arr[i];

        }
        System.out.print((double) windowSum / k + " ");

        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            System.out.print((double) windowSum / k + " ");

        }

    }

    // Count of Odd Numbers in Every Window of Size k
    // output: 2 1 2 1

    private static void countTheOdds() {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        int k = 3;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] % 2 != 0) {
                count++;
            }

        }
        System.out.print(count + " ");

        for (int i = k; i < arr.length; i++) {
            if (arr[i - k] % 2 != 0)
                count--;
            if (arr[i] % 2 != 0)
                count++;
            System.out.print(count + " ");

        }

    }

    // Count of Zeros in Every Window of Size k
    private static void counZeros() {
        int[] arr = { 0, 1, 0, 2, 0, 3 };
        int k = 3;
        int count = 0;
        // First window
        for (int i = 0; i < k; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        System.out.print(count + " ");

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            if (arr[i - k] == 0)
                count--; // remove
            if (arr[i] == 0)
                count++; // add
            System.out.print(count + " ");
        }
    }

    // Sliding window +HasSet Problems
    // poc
    private static void newSlidingStyle() {
        // find out all the windows of size 2;
        // we can move up to only arr.length - k to have all windows of size k
        int[] arr = { 10, 20, 30, 40 };
        int k = 2;
        for (int i = 0; i <= arr.length - k; i++) {
            System.out.println(arr[i] + " " + arr[i + 1]);

        }
    }

    // Count Unique Elements in Every Window of Size k

    private static void countUnqueInEveryWindow() {
        int k = 4;
        int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
        // for every window of size k
        for (int i = 0; i <= arr.length - k; i++) {
            HashSet<Integer> set = new HashSet();

            for (int j = i; j < i + k; j++) {
                set.add(arr[j]);

            }

            System.out.println(set.size());

        }

    }

    // Count distinct elements in every window of size k
    private static void countDistictElements() {
        int[] arr = { 4, 1, 1, 2, 1, 3 };
        int k = 3;

        for (int i = 0; i <= arr.length - k; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                set.add(arr[j]);

            }

            System.out.println(set.size());

        }

    }

    // Check if all elements in a window are unique
    private static void checkIfAllElemetsUnique() {
        int[] arr = { 1, 2, 3, 1, 4, 5 };
        int k = 3;

        for (int i = 0; i <= arr.length - k; i++) {
            HashSet<Integer> set = new HashSet<>();
            boolean isAllUnique = true;

            for (int j = i; j < i + k; j++) {
                if (set.contains(arr[j])) {
                    isAllUnique = false;
                    break;
                }
                set.add(arr[j]);
            }

            System.out.println(isAllUnique);
        }

    }

}
