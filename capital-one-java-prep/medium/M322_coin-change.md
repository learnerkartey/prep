# M322 - Coin Change

## Difficulty
Medium

## Category
DP

## Pattern
Bottom-up unbounded knapsack

## Problem Summary
LeetCode 322: Coin Change.

## Approach
Bottom-up unbounded knapsack

## Java Solution
```java
import java.util.*;

public class ProblemM322CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int value = coin; value <= amount; value++) {
                dp[value] = Math.min(dp[value], dp[value - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
```

## Complexity
- Time: O(amount * coins)
- Space: O(amount)
