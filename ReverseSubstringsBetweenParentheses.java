import java.util.*;

/**
 * Problem: 1190. Reverse Substrings Between Each Pair of Parentheses
 * 
 * You are given a string s that consists of lower case English letters and brackets.
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 * Your result should not contain any brackets.
 * 
 * Example:
 * Input: s = "(abcd)"
 * Output: "dcba"
 * 
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * 
 * Constraints:
 * 1 <= s.length <= 2000
 * s only contains lower case English characters and parentheses.
 * It is guaranteed that all parentheses are balanced.
 */

public class ReverseSubstringsBetweenParentheses {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                int start = stack.pop();
                reverseSubstring(chars, start + 1, i - 1);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c != '(' && c != ')') {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    private void reverseSubstring(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        ReverseSubstringsBetweenParentheses solution = new ReverseSubstringsBetweenParentheses();
        
        // Example usage:
        String input1 = "(abcd)";
        System.out.println("Input: " + input1);
        System.out.println("Output: " + solution.reverseParentheses(input1)); // Expected: "dcba"
        
        String input2 = "(u(love)i)";
        System.out.println("Input: " + input2);
        System.out.println("Output: " + solution.reverseParentheses(input2)); // Expected: "iloveu"
        
        String input3 = "(ed(et(oc))el)";
        System.out.println("Input: " + input3);
        System.out.println("Output: " + solution.reverseParentheses(input3)); // Expected: "leetcode"
    }
}
