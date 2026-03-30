# E733 - Flood Fill

## Difficulty
Easy

## Category
Matrix, DFS/BFS

## Pattern
DFS recoloring

## Problem Summary
LeetCode 733: Flood Fill.

## Approach
DFS recoloring

## Java Solution
```java
public class ProblemE733FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;
        dfs(image, sr, sc, original, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int original, int color) {
        if (r < 0 || c < 0 || r == image.length || c == image[0].length || image[r][c] != original) {
            return;
        }
        image[r][c] = color;
        dfs(image, r + 1, c, original, color);
        dfs(image, r - 1, c, original, color);
        dfs(image, r, c + 1, original, color);
        dfs(image, r, c - 1, original, color);
    }
}
```

## Complexity
- Time: O(m*n)
- Space: O(m*n)
