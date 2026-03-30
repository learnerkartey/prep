# H2251 - Number of Flowers in Full Bloom

## Difficulty
Hard

## Category
Binary Search

## Pattern
Sort starts/ends independently

## Problem Summary
LeetCode 2251: Number of Flowers in Full Bloom.

## Approach
Sort starts/ends independently

## Java Solution
```java
import java.util.*;

public class ProblemH2251NumberOfFlowersInFullBloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int[] answer = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int started = upperBound(starts, people[i]);
            int ended = lowerBound(ends, people[i]);
            answer[i] = started - ended;
        }
        return answer;
    }

    private int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
```

## Complexity
- Time: O((n+m) log n)
- Space: O(n)
