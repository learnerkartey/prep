# M048 - Rotate Image

## Difficulty
Medium

## Category
Matrix

## Pattern
Transpose then reverse rows

## Problem Summary
LeetCode 48: Rotate Image.

## Approach
Transpose then reverse rows

## Java Solution
```java
public class ProblemM048RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n; r++) {
            for (int c = r + 1; c < n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
        for (int[] row : matrix) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
    }
}
```

## Complexity
- Time: O(n)
- Space: O(1)
