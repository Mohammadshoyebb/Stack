// 20. Valid Parentheses
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// - Open brackets must be closed by the same type of brackets.
// - Open brackets must be closed in the correct order.
// - Every close bracket has a corresponding open bracket of the same type.
//
// Example 1:
// Input: s = "()"
// Output: true
//
// Example 2:
// Input: s = "()[]{}"
// Output: true
//
// Example 3:
// Input: s = "(]"
// Output: false
//
// Constraints:
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        
        // Test cases
        System.out.println(vp.isValid("()"));       // Output: true
        System.out.println(vp.isValid("()[]{}"));   // Output: true
        System.out.println(vp.isValid("(]"));       // Output: false
    }
}
