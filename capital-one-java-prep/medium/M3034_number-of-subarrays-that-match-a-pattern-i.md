# M3034 - Number of Subarrays That Match a Pattern I

## Difficulty
Medium

## Category
Arrays, Sliding Window

## Pattern
Compare adjacent relation sequence

## Problem Summary
LeetCode 3034: Number of Subarrays That Match a Pattern I.

## Approach
Compare adjacent relation sequence

## Java Solution
```java
public class ProblemM3034NumberOfSubarraysThatMatchAPatternI {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int answer = 0;
        for (int start = 0; start + pattern.length < nums.length; start++) {
            boolean ok = true;
            for (int j = 0; j < pattern.length; j++) {
                int cmp = Integer.compare(nums[start + j + 1], nums[start + j]);
                if (cmp != pattern[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) answer++;
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n*m)
- Space: O(1)
