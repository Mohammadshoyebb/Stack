/*
 * Problem: Insert an Element at the Bottom of a Stack
 * Difficulty: Easy
 * Accuracy: 71.19%
 * Submissions: 40K+
 * Points: 2
 * 
 * You are given a stack 'st' of 'n' integers and an element 'x'. You have to insert 'x' at the bottom of the given stack.
 * 
 * Note: Everywhere in this problem, the bottommost element of the stack is shown first while printing the stack.
 * 
 * Example 1:
 * Input:
 * n = 5
 * x = 2
 * st = {4,3,2,1,8}
 * Output:
 * {2,4,3,2,1,8}
 * Explanation:
 * After insertion of 2, the final stack will be {2,4,3,2,1,8}.
 * 
 * Example 2:
 * Input:
 * n = 3
 * x = 4
 * st = {5,3,1}
 * Output:
 * {4,5,3,1}
 * Explanation:
 * After insertion of 4, the final stack will be {4,5,3,1}.
 * 
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function 'insertAtBottom()' 
 * which takes a stack 'st' and an integer 'x' as inputs and returns the modified stack after insertion.
 * 
 * Expected Time Complexity: O(n)
 * Expected Auxiliary Space: O(n)
 * 
 * Constraints:
 * 1 <= n <= 10^5
 * 0 <= x, elements of stack <= 10^9
 */
import java.util.Stack;
public class InsertAtBottomOfStack {
    
    // Function to insert element at the bottom of the stack
    public static void insertAtBottom(Stack<Integer> st, int x) {
        // Base case: if stack is empty, push the element
        if (st.isEmpty()) {
            st.push(x);
            return;
        }
        
        // Pop the top element
        int topElement = st.pop();
        
        // Recursive call to insert element at the bottom
        insertAtBottom(st, x);
        
        // Push the top element back
        st.push(topElement);
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        // Example 1
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(8);
        System.out.println("Original Stack: " + stack);
        insertAtBottom(stack, 2);
        System.out.println("Stack after inserting 2 at the bottom: " + stack);
        
        // Clear the stack for the next example
        stack.clear();
        
        // Example 2
        stack.push(5);
        stack.push(3);
        stack.push(1);
        System.out.println("Original Stack: " + stack);
        insertAtBottom(stack, 4);
        System.out.println("Stack after inserting 4 at the bottom: " + stack);
    }
}

