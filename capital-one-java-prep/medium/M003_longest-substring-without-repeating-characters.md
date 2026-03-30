# M003 - Longest Substring Without Repeating Characters

## Difficulty
Medium

## Category
String, Sliding Window

## Pattern
Sliding window with last seen index

## Problem Summary
LeetCode 3: Longest Substring Without Repeating Characters.

## Approach
Sliding window with last seen index

## Java Solution
```java
import java.util.*;

public class ProblemM003LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (lastSeen.containsKey(ch)) {
                left = Math.max(left, lastSeen.get(ch) + 1);
            }
            lastSeen.put(ch, right);
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(min(n, alphabet))
