# M3101 - Count Alternating Subarrays

## Difficulty
Medium

## Category
Arrays, DP

## Pattern
Extend current alternating run

## Problem Summary
LeetCode 3101: Count Alternating Subarrays.

## Approach
Extend current alternating run

## Java Solution
```java
public class ProblemM3101CountAlternatingSubarrays {
    public long countAlternatingSubarrays(int[] nums) {
        long answer = 1;
        long current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) current++;
            else current = 1;
            answer += current;
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(1)
