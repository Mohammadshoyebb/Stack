/*
Next Greater Element
Difficulty: Medium
Accuracy: 32.95%
Submissions: 385K+
Points: 4

Given an array arr[ ] of n elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.

Examples:

Input: arr[] = [1 3 2 4], n = 4
Output: 3 4 4 -1
Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist, it is -1.

Input: arr[] = [6 8 0 1 3], n = 5
Output: 8 -1 1 3 -1
Explanation: The next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1, for 1 it is 3 and then for 3 there is no larger element on right and hence -1.

Input: arr[] = [10, 20, 30, 50], n = 4
Output: 20 30 50 -1
Explanation: For a sorted array, the next element is next greater element also except for the last element.

Input: arr[] = [50, 40, 30, 10], n = 4
Output: -1 -1 -1 -1
Explanation: For a reverse sorted array, the next greater element is always -1.

Expected Time Complexity : O(n)
Expected Auxiliary Space : O(n)

Constraints:
1 ≤ n ≤ 10^6
0 ≤ arr[i] ≤ 10^18
*/

import java.util.Stack;

public class NextGreaterElement {
    // Function to find the next greater element for each element of the array.
    public static long[] nextGreaterElement(long[] arr, int n) { 
        Stack<Long> st = new Stack<>();
        long[] result = new long[n]; // Result array to store next greater elements
        
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from stack that are smaller than or equal to current element
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            
            // If stack is empty, there's no greater element to the right
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek(); // Top of stack is the next greater element
            }
            
            st.push(arr[i]); // Push current element onto stack
        }
        
        return result;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        long[] arr1 = {1, 3, 2, 4};
        int n1 = arr1.length;
        long[] result1 = nextGreaterElement(arr1, n1);
        System.out.print("Output for arr1: ");
        for (long num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        long[] arr2 = {6, 8, 0, 1, 3};
        int n2 = arr2.length;
        long[] result2 = nextGreaterElement(arr2, n2);
        System.out.print("Output for arr2: ");
        for (long num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        long[] arr3 = {10, 20, 30, 50};
        int n3 = arr3.length;
        long[] result3 = nextGreaterElement(arr3, n3);
        System.out.print("Output for arr3: ");
        for (long num : result3) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        long[] arr4 = {50, 40, 30, 10};
        int n4 = arr4.length;
        long[] result4 = nextGreaterElement(arr4, n4);
        System.out.print("Output for arr4: ");
        for (long num : result4) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
