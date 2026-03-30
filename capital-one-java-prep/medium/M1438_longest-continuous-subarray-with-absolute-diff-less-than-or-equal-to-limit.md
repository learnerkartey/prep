# M1438 - Longest Continuous Subarray With Absolute Diff Less Than Or Equal To Limit

## Difficulty
Medium

## Category
Sliding Window, Deque

## Pattern
Maintain max/min deques

## Problem Summary
LeetCode 1438: Longest Continuous Subarray With Absolute Diff Less Than Or Equal To Limit.

## Approach
Maintain max/min deques

## Java Solution
```java
import java.util.*;

public class ProblemM1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0;
        int answer = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) maxDeque.pollLast();
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) minDeque.pollLast();
            maxDeque.offerLast(right);
            minDeque.offerLast(right);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(n)
