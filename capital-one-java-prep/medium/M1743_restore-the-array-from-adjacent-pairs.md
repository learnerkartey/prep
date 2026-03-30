# M1743 - Restore the Array From Adjacent Pairs

## Difficulty
Medium

## Category
Graph

## Pattern
Path reconstruction from degree-1 endpoint

## Problem Summary
LeetCode 1743: Restore the Array From Adjacent Pairs.

## Approach
Path reconstruction from degree-1 endpoint

## Java Solution
```java
import java.util.*;

public class ProblemM1743RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        int n = adjacentPairs.length + 1;
        int[] answer = new int[n];
        answer[0] = start;
        answer[1] = graph.get(start).get(0);

        for (int i = 2; i < n; i++) {
            List<Integer> nexts = graph.get(answer[i - 1]);
            answer[i] = (nexts.get(0) == answer[i - 2]) ? nexts.get(1) : nexts.get(0);
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(n)
