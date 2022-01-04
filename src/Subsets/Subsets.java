package Subsets;

import java.util.Stack;

public class Subsets {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        int[] arr = {1, 3, 2};
        printSubsets(0, arr, stack);
    }

    private static void printSubsets(int index, int[] arr, Stack<Integer> stack) {
        if(arr.length == index) {
            System.out.println(stack);
            return;
        }
//        pick
        stack.push(arr[index]);
        printSubsets(index + 1, arr, stack);
//        not pick
        stack.pop();
        printSubsets(index + 1, arr, stack);
    }
}
