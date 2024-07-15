import java.util.*;

/**
 * 726. Number of Atoms
 * Hard
 * 
 * Given a string formula representing a chemical formula, return the count of each atom.
 * 
 * The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
 * 
 * One or more digits representing that element's count may follow if the count is greater than 1. If the count is 1, no digits will follow.
 * 
 * For example, "H2O" and "H2O2" are possible, but "H1O2" is impossible.
 * Two formulas are concatenated together to produce another formula.
 * 
 * For example, "H2O2He3Mg4" is also a formula.
 * A formula placed in parentheses, and a count (optionally added) is also a formula.
 * 
 * For example, "(H2O2)" and "(H2O2)3" are formulas.
 * Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 * 
 * The test cases are generated so that all the values in the output fit in a 32-bit integer.
 * 
 * Example 1:
 * Input: formula = "H2O"
 * Output: "H2O"
 * Explanation: The count of elements are {'H': 2, 'O': 1}.
 * 
 * Example 2:
 * Input: formula = "Mg(OH)2"
 * Output: "H2MgO2"
 * Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * 
 * Example 3:
 * Input: formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 * 
 * Constraints:
 * 1 <= formula.length <= 1000
 * formula consists of English letters, digits, '(', and ')'.
 * formula is always valid.
 */

public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        int[] stack = new int[1000];
        int top = 0, multiplier = 1, freq = 0;
        char[] c = formula.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] >= 'a' && c[i] <= 'z') {
                int end = i--;
                while (i >= 0 && c[i] >= 'a' && c[i] <= 'z') i--;
                String key = new String(c, i + 1, end - i);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if (c[i] >= 'A' && c[i] <= 'Z') {
                String key = new String(c, i, 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if (c[i] >= '0' && c[i] <= '9') {
                freq = c[i] - '0';
                int p = 10;
                while (i - 1 >= 0 && c[i - 1] >= '0' && c[i - 1] <= '9') {
                    freq += p * (c[--i] - '0');
                    p *= 10;
                }
            } else if (c[i] == ')') {
                stack[top++] = multiplier;
                multiplier *= Math.max(freq, 1);
                freq = 0;
            } else {
                multiplier = stack[--top];
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key);
            int f = map.get(key);
            if (f > 1) sb.append(f);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NumberOfAtoms solution = new NumberOfAtoms();
        System.out.println(solution.countOfAtoms("H2O")); // Output: "H2O"
        System.out.println(solution.countOfAtoms("Mg(OH)2")); // Output: "H2MgO2"
        System.out.println(solution.countOfAtoms("K4(ON(SO3)2)2")); // Output: "K4N2O14S4"
    }
}

//========================================Shashwat sir Method Explained==========================================

/*
 * class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<HashMap<String,Integer>> stack = new Stack<>();
        stack.push(new HashMap<String,Integer>());
        int index=0;
        // O(N) + O(K)
        //O(N)*(N)
        while(index<n){
            char ch = formula.charAt(index);
            if(ch == '('){
                stack.push(new HashMap<String,Integer>());
                index++;
            }else if(ch == ')'){
                HashMap<String,Integer> curMap = stack.pop();
                index++; //move to the next char
                //find the multiplier
                StringBuilder multiplier = new StringBuilder();
                while(index < n && Character.isDigit(formula.charAt(index))){
                    multiplier.append(formula.charAt(index));
                    index++;
                }
                //multiply the count - ()n
                if(multiplier.length()>0){
                    int m = Integer.parseInt(multiplier.toString());
                    for(String atom : curMap.keySet()){
                        curMap.put(atom, curMap.get(atom) * m);
                    }
                }
                //insert popped map elements into stack top
                for(String atom : curMap.keySet()){
                    stack.peek().put(
                        atom,
                        stack.peek().getOrDefault(atom,0)+curMap.get(atom)
                    );
                }

            }else{ //Atom name and count
                // take the uppercase letter 
                StringBuilder atomName = new StringBuilder();
                atomName.append(ch);
                index++;
                //collect all lowercase letters
                while(index < n && Character.isLowerCase(formula.charAt(index))){
                    atomName.append(formula.charAt(index));
                    index++;
                }
                StringBuilder count = new StringBuilder();
                while(index < n && Character.isDigit(formula.charAt(index))){
                    count.append(formula.charAt(index));
                    index++;
                }
                int c = (count.length()>0)?Integer.parseInt(count.toString()):1;
                stack.peek().put(
                        atomName.toString(),
                        stack.peek().getOrDefault(atomName.toString(),0)+c
                    );
            }
        }
        // 2K
        TreeMap<String,Integer> sortedMap = new TreeMap<>(stack.peek());
        StringBuilder res = new StringBuilder();
        for(String atom : sortedMap.keySet()){
            res.append(atom);
            int count = sortedMap.get(atom); 
            if(count>1){
                res.append(count);
            }
        }
        return res.toString();
    }
}
 */
