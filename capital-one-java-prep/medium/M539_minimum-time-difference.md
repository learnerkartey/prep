# M539 - Minimum Time Difference

## Difficulty
Medium

## Category
Sorting

## Pattern
Convert to minutes and sort

## Problem Summary
LeetCode 539: Minimum Time Difference.

## Approach
Convert to minutes and sort

## Java Solution
```java
import java.util.*;

public class ProblemM539MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = new ArrayList<>();
        for (String time : timePoints) {
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            minutes.add(h * 60 + m);
        }
        Collections.sort(minutes);

        int answer = 1440 - minutes.get(minutes.size() - 1) + minutes.get(0);
        for (int i = 1; i < minutes.size(); i++) {
            answer = Math.min(answer, minutes.get(i) - minutes.get(i - 1));
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n log n)
- Space: O(n)
