package top200;

import base.ListNode;

public class 反转链表 {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return preNode;
    }

}
