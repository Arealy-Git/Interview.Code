package top200;

import base.ListNode;

public class t18_删除链表的倒数第n个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        size = size - n;
        if (size == 0) {
            return head.next;
        }
        cur = head;
        for (int i = 0; i < size - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

}
