package top200;

import base.ListNode;

import java.util.Stack;

public class 两个链表生成相加链表 {

    public ListNode addInList(ListNode head1, ListNode head2) {

        head1 = reverse(head1);
        head2 = reverse(head2);

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int x = head1 == null ? 0 : head1.val;
            int y = head2 == null ? 0 : head2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }

        return reverse(pre.next);

    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
