# M122 - Best Time to Buy and Sell Stock II

## Difficulty
Medium

## Category
Greedy, Arrays

## Pattern
Take every positive rise

## Problem Summary
LeetCode 122: Best Time to Buy and Sell Stock II.

## Approach
Take every positive rise

## Java Solution
```java
public class ProblemM122BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int answer = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                answer += prices[i] - prices[i - 1];
            }
        }
        return answer;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(1)
