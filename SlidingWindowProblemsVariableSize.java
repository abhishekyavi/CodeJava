package CodeJava;

//sliding window problems with variable winodw size
public class SlidingWindowProblemsVariableSize {
    public static void main(String[] args) {
        // findSmallestSubArry();
        findLongestSubArray();

    }

    // Find the smallest subarray length where the sum is greater than or equal to a
    // target number.

    private static void findSmallestSubArry() {
        int[] arr = { 2, 3, 1, 2, 4, 3 };
        int target = 7;

        int minlenghth = Integer.MAX_VALUE;
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            windowSum = windowSum + arr[end];
            while (windowSum >= target) {
                // shrinking logic of window and its sum
                windowSum = windowSum - arr[start];
                start++;
                int windowlength = end - start + 1;
                minlenghth = Math.min(windowlength, minlenghth);
            }

        }

        System.out.println(">>>>>" + minlenghth);

    }

    // Given an array of positive integers and a number K,
    // find the length of the longest subarray whose sum is less than or equal to K.
    /*
     * Logic to solve
     * Use two pointers start and end to form a window.
     * Expand end to increase sum.
     * If the sum exceeds K, shrink the window from the start.
     */
    private static void findLongestSubArray() {
        int[] arr = { 2, 1, 3, 2, 1, 1, 1 };
        int k = 5;
        int start = 0;
        int windowSum = 0;
        int maxLength = 0;

        for (int end = 0; end < arr.length; end++) {
            windowSum = windowSum + arr[end];
            while (windowSum > k) { // because the sum should be always less then k

                // shrink the window from start
                windowSum = windowSum - arr[start];
                start++;
            }
            int windowlength = end - start + 1;
            maxLength = Math.max(maxLength, windowlength);

        }
        System.out.println(maxLength);
    }

    //Problem 1: Longest Subarray with Sum ≤ K
    private static void longestSubArraywithSumlessthenK(){
        
    }


    
}