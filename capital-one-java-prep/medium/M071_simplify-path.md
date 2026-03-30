# M071 - Simplify Path

## Difficulty
Medium

## Category
Stack, String

## Pattern
Split and normalize segments

## Problem Summary
LeetCode 71: Simplify Path.

## Approach
Split and normalize segments

## Java Solution
```java
import java.util.*;

public class ProblemM071SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) continue;
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(part);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder answer = new StringBuilder();
        Iterator<String> it = stack.descendingIterator();
        while (it.hasNext()) {
            answer.append('/').append(it.next());
        }
        return answer.toString();
    }
}
```

## Complexity
- Time: O(n)
- Space: O(n)
