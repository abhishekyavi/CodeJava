package CodeJava;

public class ArrayPractice {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        // revrseArray(arr);
        // findLargestElement();
        // sumofArray();
        // findOddnEven();
        // ifArraySorted();
        findAllUniquePairs();
    }

    public static void revrseArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void findLargestElement() {
        int[] arr = { 10, 24, 23, 45, 55, 22, 34 };
        int largestNo = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > largestNo) {
                largestNo = arr[i];
            }
        }
        System.out.println("::" + largestNo);
    }

    private static void sumofArray() {
        int[] arr = { 1, 2, 3 };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println(">>>" + sum);
    }

    private static void findOddnEven() {
        int[] arr = { 4, 7, 2, 9, 6, 11, 8 };
        int oddcount = 0;
        int evencount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evencount++;
            } else {
                oddcount++;
            }
        }
        System.out.println(evencount + "--" + oddcount);
    }

    // Check if an Array is Sorted
    private static void ifArraySorted() {
        boolean issorted = true;
        int[] arr = { 2, 4, 6, 8, 10 };
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                issorted = false;
                break;
            }

        }
        System.out.println(issorted);
    }

    // : Find all unique pairs in an array.
    private static void findAllUniquePairs() {
        int[] arr = { 3, 4, 7, 2, 1, 6, 5 };
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                System.out.println(arr[i] + "-" + arr[j]);

            }

        }

    }

}
