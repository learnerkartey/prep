# M128 - Longest Consecutive Sequence

## Difficulty
Medium

## Category
HashSet

## Pattern
Start-of-sequence expansion

## Problem Summary
LeetCode 128: Longest Consecutive Sequence.

## Approach
Start-of-sequence expansion

## Java Solution
```java
import java.util.*;

public class ProblemM128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int answer = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                answer = Math.max(answer, length);
            }
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(n)
