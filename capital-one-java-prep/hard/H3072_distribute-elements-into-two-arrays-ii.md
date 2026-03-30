# H3072 - Distribute Elements Into Two Arrays II

## Difficulty
Hard

## Category
Fenwick Tree, Order Statistics

## Pattern
Compare greater-than counts using Fenwick trees

## Problem Summary
LeetCode 3072: Distribute Elements Into Two Arrays II.

## Approach
Compare greater-than counts using Fenwick trees

## Java Solution
```java
import java.util.*;

public class ProblemH3072DistributeElementsIntoTwoArraysII {
    private static class Fenwick {
        int[] bit;
        Fenwick(int n) { bit = new int[n + 2]; }

        void add(int index, int delta) {
            for (int i = index; i < bit.length; i += i & -i) bit[i] += delta;
        }

        int sum(int index) {
            int answer = 0;
            for (int i = index; i > 0; i -= i & -i) answer += bit[i];
            return answer;
        }
    }

    public int[] resultArray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> rank = new HashMap<>();
        int idx = 1;
        for (int value : sorted) {
            if (!rank.containsKey(value)) rank.put(value, idx++);
        }

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        Fenwick bit1 = new Fenwick(idx + 2);
        Fenwick bit2 = new Fenwick(idx + 2);

        arr1.add(nums[0]);
        bit1.add(rank.get(nums[0]), 1);
        arr2.add(nums[1]);
        bit2.add(rank.get(nums[1]), 1);

        for (int i = 2; i < nums.length; i++) {
            int r = rank.get(nums[i]);
            int greater1 = arr1.size() - bit1.sum(r);
            int greater2 = arr2.size() - bit2.sum(r);

            if (greater1 > greater2 || (greater1 == greater2 && arr1.size() <= arr2.size())) {
                arr1.add(nums[i]);
                bit1.add(r, 1);
            } else {
                arr2.add(nums[i]);
                bit2.add(r, 1);
            }
        }

        int[] answer = new int[nums.length];
        int k = 0;
        for (int value : arr1) answer[k++] = value;
        for (int value : arr2) answer[k++] = value;
        return answer;
    }
}
```

## Complexity
- Time: O(n log n)
- Space: O(n)
