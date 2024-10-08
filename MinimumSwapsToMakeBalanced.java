/*
    1963. Minimum Number of Swaps to Make the String Balanced

    You are given a 0-indexed string s of even length n. The string consists of exactly 
    n / 2 opening brackets '[' and n / 2 closing brackets ']'.

    A string is called balanced if and only if:
    - It is the empty string, or
    - It can be written as AB, where both A and B are balanced strings, or
    - It can be written as [C], where C is a balanced string.

    You may swap the brackets at any two indices any number of times.

    Return the minimum number of swaps to make s balanced.

    Example 1:
    Input: s = "][]["
    Output: 1
    Explanation: You can make the string balanced by swapping index 0 with index 3.
    The resulting string is "[[]]".

    Example 2:
    Input: s = "]]][[["
    Output: 2
    Explanation: 
    - Swap index 0 with index 4. s = "[]][][".
    - Swap index 1 with index 5. s = "[[][]]".

    Example 3:
    Input: s = "[]"
    Output: 0
    Explanation: The string is already balanced.

    Constraints:
    - n == s.length
    - 2 <= n <= 10^6
    - n is even.
    - s[i] is either '[' or ']'.
    - The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2.
*/
import java.util.Stack;
public class MinimumSwapsToMakeBalanced {

    // Approach 1: Greedy approach
    public int minSwaps(String s) {
        int unbalancedCount = 0; // Tracks the number of unbalanced closing brackets ']'
        int maxUnbalanced = 0;   // Tracks the maximum number of unbalanced brackets at any point

        // Iterate through the string
        for (char c : s.toCharArray()) {
            if (c == '[') {
                unbalancedCount--; // A matching opening bracket reduces unbalanced count
            } else {
                unbalancedCount++; // A closing bracket increases unbalanced count
            }
            
            // Track the maximum unbalanced closing brackets encountered
            maxUnbalanced = Math.max(maxUnbalanced, unbalancedCount);
        }

        // We need (maxUnbalanced + 1) / 2 swaps to balance the string
        return (maxUnbalanced + 1) / 2;
    }

    // Approach 2: Stack-based approach
    public int minSwapsUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it to the stack
            if (c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek() == '[') {
                // If it's a closing bracket and there's a matching opening bracket, pop the stack
                stack.pop();
            }
        }
        
        // The size of the stack after processing will tell us how many unmatched brackets remain
        // Half of the unmatched brackets need to be swapped to balance the string
        return (stack.size() + 1) / 2;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        MinimumSwapsToMakeBalanced solution = new MinimumSwapsToMakeBalanced();

        // Test case 1
        String s1 = "][][";
        System.out.println("Minimum swaps needed for '" + s1 + "': " + solution.minSwaps(s1)); // Greedy Output: 1
        System.out.println("Minimum swaps needed (stack approach) for '" + s1 + "': " + solution.minSwapsUsingStack(s1)); // Stack Output: 1

        // Test case 2
        String s2 = "]]][[[";
        System.out.println("Minimum swaps needed for '" + s2 + "': " + solution.minSwaps(s2)); // Greedy Output: 2
        System.out.println("Minimum swaps needed (stack approach) for '" + s2 + "': " + solution.minSwapsUsingStack(s2)); // Stack Output: 2

        // Test case 3
        String s3 = "[]";
        System.out.println("Minimum swaps needed for '" + s3 + "': " + solution.minSwaps(s3)); // Greedy Output: 0
        System.out.println("Minimum swaps needed (stack approach) for '" + s3 + "': " + solution.minSwapsUsingStack(s3)); // Stack Output: 0
    }
}
