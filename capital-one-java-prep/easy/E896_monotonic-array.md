# E896 - Monotonic Array

## Difficulty
Easy

## Category
Arrays

## Pattern
Track nondecreasing/nonincreasing

## Problem Summary
LeetCode 896: Monotonic Array.

## Approach
Track nondecreasing/nonincreasing

## Java Solution
```java
public class ProblemE896MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        boolean nonDecreasing = true;
        boolean nonIncreasing = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) nonDecreasing = false;
            if (nums[i] > nums[i - 1]) nonIncreasing = false;
        }
        return nonDecreasing || nonIncreasing;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(1)
