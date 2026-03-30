# H546 - Remove Boxes

## Difficulty
Hard

## Category
DP

## Pattern
Memoized 3D interval DP

## Problem Summary
LeetCode 546: Remove Boxes.

## Approach
Memoized 3D interval DP

## Java Solution
```java
public class ProblemH546RemoveBoxes {
    private int[][][] memo;
    private int[] boxes;

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        this.boxes = boxes;
        this.memo = new int[n][n][n];
        return dfs(0, n - 1, 0);
    }

    private int dfs(int left, int right, int sameCount) {
        if (left > right) return 0;
        if (memo[left][right][sameCount] != 0) return memo[left][right][sameCount];

        int originalLeft = left;
        int originalSame = sameCount;
        while (left + 1 <= right && boxes[left] == boxes[left + 1]) {
            left++;
            sameCount++;
        }

        int answer = (sameCount + 1) * (sameCount + 1) + dfs(left + 1, right, 0);

        for (int mid = left + 1; mid <= right; mid++) {
            if (boxes[mid] == boxes[left]) {
                answer = Math.max(answer, dfs(left + 1, mid - 1, 0) + dfs(mid, right, sameCount + 1));
            }
        }

        memo[originalLeft][right][originalSame] = answer;
        return answer;
    }
}
```

## Complexity
- Time: O(n^4)
- Space: O(n^3)
