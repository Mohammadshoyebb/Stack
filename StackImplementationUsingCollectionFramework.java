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
 * CustomStack s = new CustomStack();
 * s.push(1);
 * s.push(2);
 * s.push(3);
 * 
 * Output:
 * s.pop(); // returns 3
 * s.peek(); // returns 2
 * s.pop(); // returns 2
 * s.pop(); // returns 1
 * s.pop(); // returns -1 (stack is empty)
 */

public class StackImplementationUsingCollectionFramework {
    static class CustomStack {
        private Stack<Integer> stack;

        public CustomStack() {
            stack = new Stack<>();
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return stack.isEmpty();
        }

        // Push an element onto the stack
        public void push(int data) {
            stack.push(data);
        }

        // Pop an element from the stack
        public int pop() {
            if (isEmpty()) {
                return -1; // Return -1 if the stack is empty
            }
            return stack.pop();
        }

        // Peek at the top element of the stack
        public int peek() {
            if (isEmpty()) {
                return -1; // Return -1 if the stack is empty
            }
            return stack.peek();
        }
    }

    public static void main(String[] args) {
        CustomStack s = new CustomStack();

        // Example 1: Push multiple elements and pop them
        s.push(95);
        s.push(87);
        s.push(0);
        s.push(4);
        s.push(5);

        System.out.println("Example 1:");
        while (!s.isEmpty()) {
            System.out.println("Peek: " + s.peek()); // Output the top element
            System.out.println("Pop: " + s.pop()); // Remove and output the top element
        }
        System.out.println();

        // Example 2: Push and pop elements with intermediate checks
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Example 2:");
        System.out.println("Peek: " + s.peek()); // Should output 30
        System.out.println("Pop: " + s.pop()); // Should output 30
        System.out.println("Peek: " + s.peek()); // Should output 20
        System.out.println("Pop: " + s.pop()); // Should output 20
        System.out.println("Peek: " + s.peek()); // Should output 10
        System.out.println("Pop: " + s.pop()); // Should output 10
        System.out.println("Pop: " + s.pop()); // Should output -1 (stack is empty)
        System.out.println();

        // Example 3: Push a single element and check stack status
        s.push(42);

        System.out.println("Example 3:");
        System.out.println("Peek: " + s.peek()); // Should output 42
        System.out.println("Is stack empty: " + s.isEmpty()); // Should output false
        System.out.println("Pop: " + s.pop()); // Should output 42
        System.out.println("Is stack empty: " + s.isEmpty()); // Should output true
    }
}

