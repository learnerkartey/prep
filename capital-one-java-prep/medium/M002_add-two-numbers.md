# M002 - Add Two Numbers

## Difficulty
Medium

## Category
Linked List

## Pattern
Digit-by-digit linked list addition

## Problem Summary
LeetCode 2: Add Two Numbers.

## Approach
Digit-by-digit linked list addition

## Java Solution
```java
public class ProblemM002AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carry;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
```

## Complexity
- Time: O(max(m,n))
- Space: O(max(m,n))
