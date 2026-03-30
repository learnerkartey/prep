# H2141 - Maximum Running Time of N Computers

## Difficulty
Hard

## Category
Binary Search

## Pattern
Binary search feasible time using capped contributions

## Problem Summary
LeetCode 2141: Maximum Running Time of N Computers.

## Approach
Binary search feasible time using capped contributions

## Java Solution
```java
public class ProblemH2141MaximumRunningTimeOfNComputers {
    public long maxRunTime(int n, int[] batteries) {
        long total = 0;
        for (int battery : batteries) total += battery;

        long left = 0;
        long right = total / n;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (canRun(mid, n, batteries)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private boolean canRun(long time, int n, int[] batteries) {
        long power = 0;
        for (int battery : batteries) {
            power += Math.min((long) battery, time);
        }
        return power >= time * n;
    }
}
```

## Complexity
- Time: O(m log(sum))
- Space: O(1)
