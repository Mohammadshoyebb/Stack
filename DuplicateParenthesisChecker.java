/**
 * Find if an expression has duplicate parenthesis or not
 * 
 * Given a balanced expression, find if it contains duplicate parenthesis or not.
 * A set of parenthesis are duplicate if the same subexpression is surrounded by multiple parenthesis.
 * 
 * Examples:
 * 
 * Below expressions have duplicate parenthesis:
 * 1. ((a+b)+((c+d)))
 *    The subexpression "c+d" is surrounded by two pairs of brackets.
 * 
 * 2. (((a+(b)))+(c+d))
 *    The subexpression "a+(b)" is surrounded by two pairs of brackets.
 * 
 * 3. (((a+(b))+c+d))
 *    The whole expression is surrounded by two pairs of brackets.
 * 
 * 4. ((a+(b))+(c+d))
 *    (b) and ((a+(b)) is surrounded by two pairs of brackets but, it will not be counted as duplicate.
 * 
 * Below expressions don't have any duplicate parenthesis:
 * 1. ((a+b)+(c+d))
 *    No subexpression is surrounded by duplicate brackets.
 */

 import java.util.Stack;

 public class DuplicateParenthesisChecker {
     public static boolean findDuplicateParenthesis(String s) {
         Stack<Character> stack = new Stack<>();
         
         for (int i = 0; i < s.length(); i++) {
             char ch = s.charAt(i);
 
             // If current character is a closing parenthesis
             if (ch == ')') {
                 int count = 0;
 
                 // Count the number of characters inside the current set of parentheses
                 while (stack.pop() != '(') {
                     count++;
                 }
 
                 // If count is less than 1, it means there was nothing or just one character inside,
                 // hence duplicate parentheses
                 if (count < 1) {
                     return true;
                 }
             } else {
                 // Push current character to stack
                 stack.push(ch);
             }
         }
         return false;
     }
 
     public static void main(String[] args) {
         String expr1 = "((a+b)+((c+d)))";
         String expr2 = "(((a+(b)))+(c+d))";
         String expr3 = "(((a+(b))+c+d))";
         String expr4 = "((a+(b))+(c+d))";
         String expr5 = "((a+b)+(c+d))";
 
         System.out.println(findDuplicateParenthesis(expr1)); // true
         System.out.println(findDuplicateParenthesis(expr2)); // true
         System.out.println(findDuplicateParenthesis(expr3)); // true
         System.out.println(findDuplicateParenthesis(expr4)); // false
         System.out.println(findDuplicateParenthesis(expr5)); // false
     }
 }
 
