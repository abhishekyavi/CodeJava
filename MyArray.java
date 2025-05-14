package CodeJava;

import java.util.Scanner;

public class MyArray {
    public static void main(String[] args) {
        // int[] arr = createArray();

        int[] arr = { 1, 2, 3, 4, 5 };
        // int[] updatedarray = insertArrayMannual(arr, 1, 99);
        // int[] deletearry = deleteAnElement(arr, 1);
        // int[] myarrinsert = insertArrayMyMethod(arr, 4, 999);
        // int[] insertedArray = insrttvalueAfter(arr, 2, 999);
        // int[] afterDeletedArray = deleteElementAtIndex(arr, 2);
        int[] deletedByValue = deleteByValue(arr, 4);
        printArry(deletedByValue);
    }

    private static int[] createArray() {
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("input  : " + i + " th element ->");
            arr[i] = sc.nextInt();
        }
        System.out.print("[");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
        return arr;
    }

    private static void printArry(int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

    public static int[] insertArrayMannual(int[] arr, int pos, int element) {
        if (pos < 0 || pos > arr.length) {
            System.out.println("invalid options");
        }
        int[] updatedarry = new int[arr.length + 1];

        for (int i = 0; i < updatedarry.length; i++) {
            if (i < pos) {
                updatedarry[i] = arr[i];
            } else if (i == pos) {
                updatedarry[i] = element;
            } else {
                updatedarry[i] = arr[i - 1];
            }
        }

        return updatedarry;
    }

    public static int[] deleteAnElement(int[] arr, int pos) {
        for (int i = pos; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
        return arr;
    }

    // best method
    public static int[] insertArrayMyMethod(
            int[] orginalarr, int pos, int element) {
        int[] newarr = new int[orginalarr.length + 1];

        // copy the elements to the new array befoe the position
        for (int i = 0; i < pos; i++) {
            newarr[i] = orginalarr[i];
        }
        // now insert the new value
        newarr[pos] = element;
        // copy the rest
        for (int i = pos; i < orginalarr.length; i++) {
            newarr[i + 1] = orginalarr[i];
        }
        return newarr;
    }

    // Write a method to insert a value after a given existing element (not
    // index).

    public static int[] insrttvalueAfter(
            int arr[], int existingValue, int newValue) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == existingValue) {
                index = i + 1;
                break;
            }
        }
        if (index == -1) {
            System.out.println("value not found");
            return arr;
        }

        return insertArrayMyMethod(arr, index, newValue);
    }

    public static int[] deleteElementAtIndex(int[] arr, int index) {
        if (index < 0 || index > arr.length) {
            System.out.println("invalid index");
        }
        int[] updatedArray = new int[arr.length - 1];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                updatedArray[j] = arr[i];
                j++;
            }
        }

        return updatedArray;
    }

    // Delete by Value (First Occurrence)

    public static int[] deleteByValue(int[] arr, int value) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("element not found");
            return arr;
        }
        return deleteElementAtIndex(arr, index);
    }
}
