# E020 - Valid Parentheses

## Difficulty
Easy

## Category
Stack, String

## Pattern
Stack matching

## Problem Summary
LeetCode 20: Valid Parentheses.

## Approach
Stack matching

## Java Solution
```java
import java.util.*;

public class ProblemE020ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != ch) return false;
        }
        return stack.isEmpty();
    }
}
```

## Complexity
- Time: O(n)
- Space: O(n)
