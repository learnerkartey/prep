# M253 - Meeting Rooms II

## Difficulty
Medium

## Category
Intervals, Heap

## Pattern
Sweep rooms with min-heap end times

## Problem Summary
LeetCode 253: Meeting Rooms II.

## Approach
Sweep rooms with min-heap end times

## Java Solution
```java
import java.util.*;

public class ProblemM253MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!heap.isEmpty() && heap.peek() <= interval[0]) {
                heap.poll();
            }
            heap.offer(interval[1]);
        }
        return heap.size();
    }
}
```

## Complexity
- Time: O(n log n)
- Space: O(n)
