# M647 - Palindromic Substrings

## Difficulty
Medium

## Category
String

## Pattern
Expand around each center

## Problem Summary
LeetCode 647: Palindromic Substrings.

## Approach
Expand around each center

## Java Solution
```java
public class ProblemM647PalindromicSubstrings {
    public int countSubstrings(String s) {
        int answer = 0;
        for (int center = 0; center < s.length(); center++) {
            answer += expand(s, center, center);
            answer += expand(s, center, center + 1);
        }
        return answer;
    }

    private int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
```

## Complexity
- Time: O(n^2)
- Space: O(1)
