/*
 * 1717. Maximum Score From Removing Substrings
Solved
Medium
Topics
Companies
Hint
You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

 

Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
 

Constraints:

1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters.
 */
public class MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            return maximumGainHelper(s, y, x, 'b', 'a');
        } else {
            return maximumGainHelper(s, x, y, 'a', 'b');
        }
    }

    private int maximumGainHelper(String s, int first, int second, char firstChar, char secondChar) {
        int maxScore = 0;
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        
        // First pass to remove higher priority substring
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == firstChar && ch == secondChar) {
                sb.deleteCharAt(sb.length() - 1);
                maxScore += first;
            } else {
                sb.append(ch);
            }
        }

        // Prepare the string after first pass
        s = sb.toString();
        sb.setLength(0);

        // Second pass to remove remaining lower priority substring
        n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == secondChar && ch == firstChar) {
                sb.deleteCharAt(sb.length() - 1);
                maxScore += second;
            } else {
                sb.append(ch);
            }
        }
        
        return maxScore;
    }

    public static void main(String[] args) {
        MaximumScoreFromRemovingSubstrings sol = new MaximumScoreFromRemovingSubstrings();
        String s1 = "cdbcbbaaabab";
        int x1 = 4;
        int y1 = 5;
        System.out.println(sol.maximumGain(s1, x1, y1)); // Output: 19

        String s2 = "aabbaaxybbaabb";
        int x2 = 5;
        int y2 = 4;
        System.out.println(sol.maximumGain(s2, x2, y2)); // Output: 20
    }
}

