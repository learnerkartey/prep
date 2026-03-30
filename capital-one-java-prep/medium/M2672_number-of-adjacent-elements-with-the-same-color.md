# M2672 - Number of Adjacent Elements With the Same Color

## Difficulty
Medium

## Category
Arrays

## Pattern
Update only affected neighbors

## Problem Summary
LeetCode 2672: Number of Adjacent Elements With the Same Color.

## Approach
Update only affected neighbors

## Java Solution
```java
public class ProblemM2672NumberOfAdjacentElementsWithTheSameColor {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] answer = new int[queries.length];
        int same = 0;

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int color = queries[i][1];

            if (colors[index] != 0) {
                if (index > 0 && colors[index] == colors[index - 1]) same--;
                if (index + 1 < n && colors[index] == colors[index + 1]) same--;
            }

            colors[index] = color;

            if (index > 0 && colors[index] == colors[index - 1]) same++;
            if (index + 1 < n && colors[index] == colors[index + 1]) same++;

            answer[i] = same;
        }
        return answer;
    }
}
```

## Complexity
- Time: O(q)
- Space: O(n)
