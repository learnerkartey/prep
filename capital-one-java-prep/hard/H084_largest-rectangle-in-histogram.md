# H084 - Largest Rectangle in Histogram

## Difficulty
Hard

## Category
Stack

## Pattern
Monotonic stack with sentinel

## Problem Summary
LeetCode 84: Largest Rectangle in Histogram.

## Approach
Monotonic stack with sentinel

## Java Solution
```java
import java.util.*;

public class ProblemH084LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;

        for (int i = 0; i <= heights.length; i++) {
            int current = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > current) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;
                answer = Math.max(answer, height * width);
            }
            stack.push(i);
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(n)
