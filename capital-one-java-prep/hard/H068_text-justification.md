# H068 - Text Justification

## Difficulty
Hard

## Category
String, Greedy

## Pattern
Pack line then distribute spaces

## Problem Summary
LeetCode 68: Text Justification.

## Approach
Pack line then distribute spaces

## Java Solution
```java
import java.util.*;

public class ProblemH068TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int start = index;
            int lineLength = words[index].length();
            index++;
            while (index < words.length && lineLength + 1 + words[index].length() <= maxWidth) {
                lineLength += 1 + words[index].length();
                index++;
            }
            answer.add(buildLine(words, start, index, maxWidth, index == words.length));
        }
        return answer;
    }

    private String buildLine(String[] words, int start, int end, int maxWidth, boolean lastLine) {
        int wordsLength = 0;
        for (int i = start; i < end; i++) wordsLength += words[i].length();
        int gaps = end - start - 1;
        StringBuilder sb = new StringBuilder();

        if (lastLine || gaps == 0) {
            for (int i = start; i < end; i++) {
                if (i > start) sb.append(' ');
                sb.append(words[i]);
            }
            while (sb.length() < maxWidth) sb.append(' ');
            return sb.toString();
        }

        int totalSpaces = maxWidth - wordsLength;
        int base = totalSpaces / gaps;
        int extra = totalSpaces % gaps;

        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            if (i < end - 1) {
                int spaces = base + (i - start < extra ? 1 : 0);
                for (int s = 0; s < spaces; s++) sb.append(' ');
            }
        }
        return sb.toString();
    }
}
```

## Complexity
- Time: O(total chars)
- Space: O(maxWidth)
