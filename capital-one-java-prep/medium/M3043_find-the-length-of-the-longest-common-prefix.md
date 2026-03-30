# M3043 - Find the Length of the Longest Common Prefix

## Difficulty
Medium

## Category
Trie-like set

## Pattern
Store all numeric prefixes from arr1

## Problem Summary
LeetCode 3043: Find the Length of the Longest Common Prefix.

## Approach
Store all numeric prefixes from arr1

## Java Solution
```java
import java.util.*;

public class ProblemM3043FindTheLengthOfTheLongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }

        int answer = 0;
        for (int num : arr2) {
            int current = num;
            while (current > 0 && !prefixes.contains(current)) {
                current /= 10;
            }
            if (current > 0) {
                answer = Math.max(answer, Integer.toString(current).length());
            }
        }
        return answer;
    }
}
```

## Complexity
- Time: O(total digits)
- Space: O(total digits)
