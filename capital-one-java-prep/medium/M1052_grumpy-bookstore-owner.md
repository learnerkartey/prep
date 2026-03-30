# M1052 - Grumpy Bookstore Owner

## Difficulty
Medium

## Category
Sliding Window

## Pattern
Base satisfied + best extra window

## Problem Summary
LeetCode 1052: Grumpy Bookstore Owner.

## Approach
Base satisfied + best extra window

## Java Solution
```java
public class ProblemM1052GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int base = 0;
        int extra = 0;
        int bestExtra = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) base += customers[i];
            else extra += customers[i];

            if (i >= minutes && grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes];
            }
            bestExtra = Math.max(bestExtra, extra);
        }
        return base + bestExtra;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(1)
