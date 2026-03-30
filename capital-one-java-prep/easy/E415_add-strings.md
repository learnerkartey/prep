# E415 - Add Strings

## Difficulty
Easy

## Category
String, Math

## Pattern
Grade-school addition

## Problem Summary
LeetCode 415: Add Strings.

## Approach
Grade-school addition

## Java Solution
```java
public class ProblemE415AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder answer = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = a + b + carry;
            answer.append(sum % 10);
            carry = sum / 10;
        }
        return answer.reverse().toString();
    }
}
```

## Complexity
- Time: O(max(n,m))
- Space: O(max(n,m))
