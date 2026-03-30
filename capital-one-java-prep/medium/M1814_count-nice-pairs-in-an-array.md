# M1814 - Count Nice Pairs in an Array

## Difficulty
Medium

## Category
HashMap, Math

## Pattern
Group by num - reverse(num)

## Problem Summary
LeetCode 1814: Count Nice Pairs in an Array.

## Approach
Group by num - reverse(num)

## Java Solution
```java
import java.util.*;

public class ProblemM1814CountNicePairsInAnArray {
    private static final int MOD = 1_000_000_007;

    public int countNicePairs(int[] nums) {
        Map<Integer, Long> freq = new HashMap<>();
        long answer = 0;
        for (int num : nums) {
            int key = num - reverse(num);
            long count = freq.getOrDefault(key, 0L);
            answer = (answer + count) % MOD;
            freq.put(key, count + 1);
        }
        return (int) answer;
    }

    private int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}
```

## Complexity
- Time: O(n*digits)
- Space: O(n)
