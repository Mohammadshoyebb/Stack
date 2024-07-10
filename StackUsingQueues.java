import java.util.LinkedList;
import java.util.Queue;

/*
 * 225. Implement Stack using Queues
 * Solved
 * Easy
 * 
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * 
 * Implement the StackUsingQueues class:
 * 
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * 
 * Notes:
 * - You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * - Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 * 
 * Example:
 * 
 * Input
 * ["StackUsingQueues", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 * 
 * Explanation:
 * StackUsingQueues stack = new StackUsingQueues();
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // return 2
 * stack.pop();   // return 2
 * stack.empty(); // return False
 * 
 * Constraints:
 * - 1 <= x <= 9
 * - At most 100 calls will be made to push, pop, top, and empty.
 * - All the calls to pop and top are valid.
 * 
 * Follow-up: Can you implement the stack using only one queue?
 */

public class StackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    /** Initialize your data structure here. */
    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        // Add the new element to q2
        q2.add(x);
        
        // Move all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
    
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        
        // Example 1
        stack.push(1);
        stack.push(2);
        System.out.println("Top element: " + stack.top()); // Output: 2
        System.out.println("Pop element: " + stack.pop()); // Output: 2
        System.out.println("Is stack empty: " + stack.empty()); // Output: false
        System.out.println();
        
        // Example 2
        stack.push(3);
        System.out.println("Top element: " + stack.top()); // Output: 3
        System.out.println("Pop element: " + stack.pop()); // Output: 3
        System.out.println("Is stack empty: " + stack.empty()); // Output: true
        System.out.println();
    }
}

