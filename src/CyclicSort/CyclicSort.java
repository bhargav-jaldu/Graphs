package CyclicSort;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        cyclicSort(arr);
    }

    private static void cyclicSort(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correctIndex = arr[i] - 1;
            if(i != correctIndex) {
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int firstElement, int secondElement) {
        int temp = arr[firstElement];
        arr[firstElement] = arr[secondElement];
        arr[secondElement] = temp;
    }
}
