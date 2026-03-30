# M1166 - Design File System

## Difficulty
Medium

## Category
Design, HashMap

## Pattern
Parent path existence check

## Problem Summary
LeetCode 1166: Design File System.

## Approach
Parent path existence check

## Java Solution
```java
import java.util.*;

public class ProblemM1166DesignFileSystem {
    private final Map<String, Integer> values = new HashMap<>();

    public ProblemM1166DesignFileSystem() {
        values.put("", -1);
    }

    public boolean createPath(String path, int value) {
        if (path.isEmpty() || path.equals("/") || values.containsKey(path)) return false;
        int slash = path.lastIndexOf('/');
        String parent = path.substring(0, slash);
        if (!values.containsKey(parent)) return false;
        values.put(path, value);
        return true;
    }

    public int get(String path) {
        return values.getOrDefault(path, -1);
    }
}
```

## Complexity
- Time: O(path length)
- Space: O(number of paths)
