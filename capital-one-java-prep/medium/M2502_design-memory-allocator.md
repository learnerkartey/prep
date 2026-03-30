# M2502 - Design Memory Allocator

## Difficulty
Medium

## Category
Design, Array

## Pattern
Linear scan allocate, full scan free

## Problem Summary
LeetCode 2502: Design Memory Allocator.

## Approach
Linear scan allocate, full scan free

## Java Solution
```java
public class ProblemM2502DesignMemoryAllocator {
    private final int[] memory;

    public ProblemM2502DesignMemoryAllocator(int n) {
        this.memory = new int[n];
    }

    public int allocate(int size, int mID) {
        int free = 0;
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == 0) free++;
            else free = 0;
            if (free == size) {
                int start = i - size + 1;
                for (int j = start; j <= i; j++) memory[j] = mID;
                return start;
            }
        }
        return -1;
    }

    public int freeMemory(int mID) {
        int freed = 0;
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == mID) {
                memory[i] = 0;
                freed++;
            }
        }
        return freed;
    }
}
```

## Complexity
- Time: O(n)
- Space: O(n)
