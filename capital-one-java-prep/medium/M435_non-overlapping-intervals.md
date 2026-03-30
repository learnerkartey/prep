# M435 - Non-overlapping Intervals

## Difficulty
Medium

## Category
Greedy, Intervals

## Pattern
Keep interval with smallest end

## Problem Summary
LeetCode 435: Non-overlapping Intervals.

## Approach
Keep interval with smallest end

## Java Solution
```java
import java.util.*;

public class ProblemM435NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int removed = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                removed++;
            } else {
                end = intervals[i][1];
            }
        }
        return removed;
    }
}
```

## Complexity
- Time: O(n log n)
- Space: O(1)
