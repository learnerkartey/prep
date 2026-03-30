# M011 - Container With Most Water

## Difficulty
Medium

## Category
Arrays, Two Pointers

## Pattern
Greedy two pointers

## Problem Summary
LeetCode 11: Container With Most Water.

## Approach
Greedy two pointers

## Java Solution
```java
public class ProblemM011ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;
        while (left < right) {
            int width = right - left;
            answer = Math.max(answer, Math.min(height[left], height[right]) * width);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(1)
