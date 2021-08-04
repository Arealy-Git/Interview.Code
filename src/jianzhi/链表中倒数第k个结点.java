package jianzhi;

import base.ListNode;

public class 链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode first = pHead;

        for (int i = 0; i < k; i++) {
            if (first == null) {
                return first;
            }
            first = first.next;
        }

        ListNode last = pHead;
        while (first != null) {
            first = first.next;
            last = last.next;
        }

        return last;
    }
}
