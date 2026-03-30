# M1390 - Four Divisors

## Difficulty
Medium

## Category
Math

## Pattern
Enumerate divisors up to sqrt(n)

## Problem Summary
LeetCode 1390: Four Divisors.

## Approach
Enumerate divisors up to sqrt(n)

## Java Solution
```java
public class ProblemM1390FourDivisors {
    public int sumFourDivisors(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            answer += divisorSumIfExactlyFour(num);
        }
        return answer;
    }

    private int divisorSumIfExactlyFour(int n) {
        int count = 0;
        int sum = 0;
        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                int other = n / d;
                if (d == other) {
                    count++;
                    sum += d;
                } else {
                    count += 2;
                    sum += d + other;
                }
                if (count > 4) return 0;
            }
        }
        return count == 4 ? sum : 0;
    }
}
```

## Complexity
- Time: O(n*sqrt(max))
- Space: O(1)
