# E121 - Best Time to Buy and Sell Stock

## Difficulty
Easy

## Category
Arrays

## Pattern
Track minimum seen so far

## Problem Summary
LeetCode 121: Best Time to Buy and Sell Stock.

## Approach
Track minimum seen so far

## Java Solution
```java
public class ProblemE121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int answer = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            answer = Math.max(answer, price - minPrice);
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(1)
