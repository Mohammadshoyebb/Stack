/*
1381. Design a Stack With Increment Operation
Medium

Design a stack that supports increment operations on its elements.

Implement the CustomStack class:

- CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
- void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
- int pop() Pops and returns the top of the stack or -1 if the stack is empty.
- void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.

Example 1:

Input:
["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
Output:
[null,null,null,2,null,null,null,null,null,103,202,201,-1]

Explanation:
CustomStack stk = new CustomStack(3); // Stack is Empty []
stk.push(1);                          // stack becomes [1]
stk.push(2);                          // stack becomes [1, 2]
stk.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
stk.push(2);                          // stack becomes [1, 2]
stk.push(3);                          // stack becomes [1, 2, 3]
stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
stk.increment(5, 100);                // stack becomes [101, 102, 103]
stk.increment(2, 100);                // stack becomes [201, 202, 103]
stk.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
stk.pop();                            // return 202 --> Return top of the stack 202, stack becomes [201]
stk.pop();                            // return 201 --> Return top of the stack 201, stack becomes []
stk.pop();                            // return -1 --> Stack is empty return -1.

Constraints:
1 <= maxSize, x, k <= 1000
0 <= val <= 100
At most 1000 calls will be made to each method of increment, push, and pop each separately
*/

import java.util.LinkedList;

public class CustomStack {
    // ----- Array-based Implementation -----
    private int[] stack;
    private int[] increment;
    private int maxSize;
    private int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.increment = new int[maxSize];
        this.top = -1; // Initially, the stack is empty
    }

    // Adds x to the top of the stack if the stack has not reached maxSize
    public void push(int x) {
        if (top < maxSize - 1) {
            top++;
            stack[top] = x;
        }
    }

    // Pops and returns the top of the stack, or -1 if the stack is empty
    public int pop() {
        if (top == -1) {
            return -1;
        }
        int result = stack[top] + increment[top];
        if (top > 0) {
            increment[top - 1] += increment[top];
        }
        increment[top] = 0;
        top--;
        return result;
    }

    // Increment the bottom k elements by val
    public void increment(int k, int val) {
        int limit = Math.min(k - 1, top);
        if (limit >= 0) {
            increment[limit] += val;
        }
    }

    // ----- Linked List-based Implementation (Doubly Linked List) -----

    private class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Initializes a stack with maxSize
    public CustomStack() {
        this.size = 0;
    }

    // Adds x to the top of the linked list stack if the stack has not reached maxSize
    public void pushLinkedList(int x) {
        if (size < maxSize) {
            Node newNode = new Node(x);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }
    }

    // Pops and returns the top of the stack using linked list or -1 if the stack is empty
    public int popLinkedList() {
        if (size == 0) {
            return -1;
        }
        int result = tail.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return result;
    }

    // Increment the bottom k elements in the linked list by val
    public void incrementLinkedList(int k, int val) {
        Node current = head;
        for (int i = 0; i < Math.min(k, size); i++) {
            current.value += val;
            current = current.next;
        }
    }
}
