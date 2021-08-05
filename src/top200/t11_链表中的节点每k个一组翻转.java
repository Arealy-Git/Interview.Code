package top200;

import base.ListNode;

public class t11_链表中的节点每k个一组翻转 {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null || k < 2) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy,
                cur = head,
                temp;

        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        for (int i = 0; i < len / k; i++) {
            for (int j = 1; j < k; j++) {
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

}
