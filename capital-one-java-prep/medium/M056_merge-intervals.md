# M056 - Merge Intervals

## Difficulty
Medium

## Category
Intervals

## Pattern
Sort and merge

## Problem Summary
LeetCode 56: Merge Intervals.

## Approach
Sort and merge

## Java Solution
```java
import java.util.*;

public class ProblemM056MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0].clone();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                merged.add(current);
                current = intervals[i].clone();
            }
        }
        merged.add(current);
        return merged.toArray(new int[0][]);
    }
}
```

## Complexity
- Time: O(n log n)
- Space: O(n)
