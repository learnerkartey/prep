# M560 - Subarray Sum Equals K

## Difficulty
Medium

## Category
Prefix Sum, HashMap

## Pattern
Count previous prefix sums

## Problem Summary
LeetCode 560: Subarray Sum Equals K.

## Approach
Count previous prefix sums

## Java Solution
```java
import java.util.*;

public class ProblemM560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int prefix = 0;
        int answer = 0;

        for (int num : nums) {
            prefix += num;
            answer += count.getOrDefault(prefix - k, 0);
            count.put(prefix, count.getOrDefault(prefix, 0) + 1);
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(n)
