# E009 - Palindrome Number

## Difficulty
Easy

## Category
Math

## Pattern
Reverse half of number

## Problem Summary
LeetCode 9: Palindrome Number.

## Approach
Reverse half of number

## Java Solution
```java
public class ProblemE009PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
```

## Complexity
- Time: O(log10 n)
- Space: O(1)
