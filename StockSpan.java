import java.util.Stack;

/**
 * Stock span problem
 * Difficulty: MediumAccuracy: 43.56%Submissions: 181K+Points: 4
 * 
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock 
 * and we need to calculate the span of stocks price for all n days. 
 * The span Si of the stocks price on a given day i is defined as the maximum number of consecutive days 
 * just before the given day, for which the price of the stock on the given day is less than or equal to its price on the current day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
 * 
 * Example 1:
 * Input: 
 * N = 7, price[] = [100, 80, 60, 70, 60, 75, 85]
 * Output:
 * 1 1 1 2 1 4 6
 * Explanation:
 * Traversing the given input span 
 * 100 is greater than equal to 100 and there are no more elements behind it so the span is 1,
 * 80 is greater than equal to 80 and smaller than 100 so the span is 1,
 * 60 is greater than equal to 60 and smaller than 80 so the span is 1,
 * 70 is greater than equal to 60,70 and smaller than 80 so the span is 2,
 * 60 is greater than equal to 60 and smaller than 70 so the span is 1,
 * 75 is greater than equal to 60,70,60,75 and smaller than 100 so the span is 4,
 * 85 is greater than equal to 80,60,70,60,75,85 and smaller than 100 so the span is 6. 
 * Hence the output will be 1 1 1 2 1 4 6.
 * 
 * Example 2:
 * Input: 
 * N = 6, price[] = [10, 4, 5, 90, 120, 80]
 * Output:
 * 1 1 2 4 5 1
 * Explanation:
 * Traversing the given input span 
 * 10 is greater than equal to 10 and there are no more elements behind it so the span is 1,
 * 4 is greater than equal to 4 and smaller than 10 so the span is 1,
 * 5 is greater than equal to 4,5 and smaller than 10 so the span is 2,
 * 90 is greater than equal to all previous elements so the span is 4,
 * 120 is greater than equal to all previous elements so the span is 5,
 * 80 is greater than equal to 80 and smaller than 120 so the span is 1,
 * Hence the output will be 1 1 2 4 5 1.
 * 
 * Example 3:
 * Input: 
 * N = 8, price[] = [30, 20, 25, 28, 27, 29, 35, 40]
 * Output:
 * 1 1 2 3 1 5 6 7
 * Explanation:
 * Traversing the given input span 
 * 30 is greater than equal to 30 and there are no more elements behind it so the span is 1,
 * 20 is greater than equal to 20 and smaller than 30 so the span is 1,
 * 25 is greater than equal to 20,25 and smaller than 30 so the span is 2,
 * 28 is greater than equal to 20,25,28 and smaller than 30 so the span is 3,
 * 27 is greater than equal to 27 and smaller than 28 so the span is 1,
 * 29 is greater than equal to 27,28,29 and smaller than 30 so the span is 5,
 * 35 is greater than equal to all previous elements so the span is 6,
 * 40 is greater than equal to all previous elements so the span is 7.
 * Hence the output will be 1 1 2 3 1 5 6 7.
 */

public class StockSpan {
    // Function to calculate the span of stock's price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        // Array to store the span of each day
        int span[] = new int[n];
        // Stack to store the indices of the days
        Stack<Integer> st = new Stack<>();
        
        // Span of the first day is always 1
        span[0] = 1;
        // Push the index of the first day onto the stack
        st.push(0);
        
        // Loop through the price array starting from the second day
        for(int i = 1; i < n; i++) {
            int currPrice = price[i];
            
            // Pop elements from the stack while the stack is not empty
            // and the price of the current day is greater than or equal to the price at the index stored at the top of the stack
            while(!st.isEmpty() && currPrice >= price[st.peek()]) {
                st.pop();
            }
            
            // If the stack is empty, it means there is no previous higher price
            if(st.isEmpty()) {
                span[i] = i + 1;
            } else {
                // Otherwise, the span is the difference between the current day and the previous higher price day
                int prevHigh = st.peek();
                span[i] = i - prevHigh;
            }
            // Push the index of the current day onto the stack
            st.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        // Example 1
        int price1[] = {100, 80, 60, 70, 60, 75, 85};
        int n1 = price1.length;
        int span1[] = calculateSpan(price1, n1);
        System.out.print("Example 1: ");
        for (int i = 0; i < n1; i++) {
            System.out.print(span1[i] + " ");
        }
        System.out.println();

        // Example 2
        int price2[] = {10, 4, 5, 90, 120, 80};
        int n2 = price2.length;
        int span2[] = calculateSpan(price2, n2);
        System.out.print("Example 2: ");
        for (int i = 0; i < n2; i++) {
            System.out.print(span2[i] + " ");
        }
        System.out.println();

        // Example 3
        int price3[] = {30, 20, 25, 28, 27, 29, 35, 40};
        int n3 = price3.length;
        int span3[] = calculateSpan(price3, n3);
        System.out.print("Example 3: ");
        for (int i = 0; i < n3; i++) {
            System.out.print(span3[i] + " ");
        }
        System.out.println();
    }
}
