# M3071 - Minimum Operations to Write the Letter Y on a Grid

## Difficulty
Medium

## Category
Matrix

## Pattern
Enumerate target colors for Y and non-Y cells

## Problem Summary
LeetCode 3071: Minimum Operations to Write the Letter Y on a Grid.

## Approach
Enumerate target colors for Y and non-Y cells

## Java Solution
```java
public class ProblemM3071MinimumOperationsToWriteTheLetterYOnAGrid {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int[][] count = new int[2][3]; // 0 -> Y cells, 1 -> non-Y cells
        int yCells = 0;
        int otherCells = 0;
        int mid = n / 2;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                boolean isY = (r <= mid && (c == r || c == n - 1 - r)) || (r >= mid && c == mid);
                if (isY) {
                    count[0][grid[r][c]]++;
                    yCells++;
                } else {
                    count[1][grid[r][c]]++;
                    otherCells++;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int yColor = 0; yColor < 3; yColor++) {
            for (int otherColor = 0; otherColor < 3; otherColor++) {
                if (yColor == otherColor) continue;
                int ops = (yCells - count[0][yColor]) + (otherCells - count[1][otherColor]);
                answer = Math.min(answer, ops);
            }
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n^2)
- Space: O(1)
