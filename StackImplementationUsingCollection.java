import java.util.Stack;

/*
 * Implement a Stack using Java Collection Framework
 * 
 * Implement a last-in-first-out (LIFO) stack using the Stack class from the Java Collection Framework. 
 * The implemented stack should support all the functions of a normal stack (push, pop, peek, and isEmpty).
 * 
 * The Stack class should have the following methods:
 * 
 * boolean isEmpty() - Returns true if the stack is empty, false otherwise.
 * void push(int data) - Pushes an integer data to the top of the stack.
 * int pop() - Removes the element on the top of the stack and returns it. Returns -1 if the stack is empty.
 * int peek() - Returns the element on the top of the stack without removing it. Returns -1 if the stack is empty.
 * 
 * Example:
 * 
 * Input:
 * Stack<Integer> stack = new Stack<>();
 * stack.push(1);
 * stack.push(2);
 * stack.push(3);
 * 
 * Output:
 * stack.pop(); // returns 3
 * stack.peek(); // returns 2
 * stack.pop(); // returns 2
 * stack.pop(); // returns 1
 * stack.pop(); // returns -1 (stack is empty)
 */

public class StackImplementationUsingCollection{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Example 1: Push multiple elements and pop them
        stack.push(95);
        stack.push(87);
        stack.push(0);
        stack.push(4);
        stack.push(5);

        System.out.println("Example 1:");
        while (!stack.isEmpty()) {
            System.out.println("Peek: " + stack.peek()); // Output the top element
            System.out.println("Pop: " + stack.pop()); // Remove and output the top element
        }
        System.out.println();

        // Example 2: Push and pop elements with intermediate checks
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Example 2:");
        System.out.println("Peek: " + stack.peek()); // Should output 30
        System.out.println("Pop: " + stack.pop()); // Should output 30
        System.out.println("Peek: " + stack.peek()); // Should output 20
        System.out.println("Pop: " + stack.pop()); // Should output 20
        System.out.println("Peek: " + stack.peek()); // Should output 10
        System.out.println("Pop: " + stack.pop()); // Should output 10
        System.out.println("Pop: " + (stack.isEmpty() ? -1 : stack.pop())); // Should output -1 (stack is empty)
        System.out.println();

        // Example 3: Push a single element and check stack status
        stack.push(42);

        System.out.println("Example 3:");
        System.out.println("Peek: " + stack.peek()); // Should output 42
        System.out.println("Is stack empty: " + stack.isEmpty()); // Should output false
        System.out.println("Pop: " + stack.pop()); // Should output 42
        System.out.println("Is stack empty: " + stack.isEmpty()); // Should output true
    }
}

