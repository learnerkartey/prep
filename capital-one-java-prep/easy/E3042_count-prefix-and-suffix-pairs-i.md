# E3042 - Count Prefix and Suffix Pairs I

## Difficulty
Easy

## Category
String

## Pattern
Brute force pair checking

## Problem Summary
LeetCode 3042: Count Prefix and Suffix Pairs I.

## Approach
Brute force pair checking

## Java Solution
```java
public class ProblemE3042CountPrefixAndSuffixPairsI {
    public int countPrefixSuffixPairs(String[] words) {
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) answer++;
            }
        }
        return answer;
    }

    private boolean isPrefixAndSuffix(String small, String large) {
        return large.startsWith(small) && large.endsWith(small);
    }
}
```

## Complexity
- Time: O(n^2 * L)
- Space: O(1)
