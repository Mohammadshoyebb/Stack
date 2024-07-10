/*
 * Problem: Reverse a String using Stack
 * Difficulty: Easy
 * Accuracy: 76.17%
 * Submissions: 96K+
 * Points: 2
 * 
 * You are given a string S, the task is to reverse the string using stack.
 * 
 * Example 1:
 * 
 * Input: S="GeeksforGeeks"
 * Output: skeeGrofskeeG
 * 
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function reverse() 
 * which takes the string S as an input parameter and returns the reversed string.
 * 
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 * 
 * Constraints:
 * 1 ≤ length of the string ≤ 100
 */
import java.util.Stack;

public class ReverseStringUsingStack {
    
    // Function to reverse the string using stack
    public static String reverse(String S) {
        // Create a stack to hold characters
        Stack<Character> stack = new Stack<>();
        
        // Push all characters of the string onto the stack
        for (char ch : S.toCharArray()) {
            stack.push(ch);
        }
        
        // Pop characters from the stack to get them in reverse order
        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }
        
        // Return the reversed string
        return reversedString.toString();
    }
    
    public static void main(String[] args) {
        // Example 1
        String S1 = "GeeksforGeeks";
        System.out.println("Original String: " + S1);
        System.out.println("Reversed String: " + reverse(S1));
        
        // Example 2
        String S2 = "HelloWorld";
        System.out.println("Original String: " + S2);
        System.out.println("Reversed String: " + reverse(S2));
        
        // Example 3
        String S3 = "DataStructures";
        System.out.println("Original String: " + S3);
        System.out.println("Reversed String: " + reverse(S3));
    }
}
