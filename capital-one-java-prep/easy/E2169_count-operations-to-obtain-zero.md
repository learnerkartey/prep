# E2169 - Count Operations to Obtain Zero

## Difficulty
Easy

## Category
Math

## Pattern
Repeated subtraction

## Problem Summary
LeetCode 2169: Count Operations to Obtain Zero.

## Approach
Repeated subtraction

## Java Solution
```java
public class ProblemE2169CountOperationsToObtainZero {
    public int countOperations(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) num1 -= num2;
            else num2 -= num1;
            count++;
        }
        return count;
    }
}
```

## Complexity
- Time: O(answer)
- Space: O(1)
