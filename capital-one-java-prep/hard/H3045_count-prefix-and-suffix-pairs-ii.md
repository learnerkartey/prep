# H3045 - Count Prefix and Suffix Pairs II

## Difficulty
Hard

## Category
Trie, String

## Pattern
Trie on paired prefix/suffix characters

## Problem Summary
LeetCode 3045: Count Prefix and Suffix Pairs II.

## Approach
Trie on paired prefix/suffix characters

## Java Solution
```java
import java.util.*;

public class ProblemH3045CountPrefixAndSuffixPairsII {
    private static class Node {
        Map<Integer, Node> next = new HashMap<>();
        int endCount;
    }

    public long countPrefixSuffixPairs(String[] words) {
        Node root = new Node();
        long answer = 0;

        for (String word : words) {
            Node node = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                int key = (word.charAt(i) << 16) | word.charAt(n - 1 - i);
                node = node.next.computeIfAbsent(key, k -> new Node());
                answer += node.endCount;
            }
            node.endCount++;
        }
        return answer;
    }
}
```

## Complexity
- Time: O(total characters)
- Space: O(total characters)
