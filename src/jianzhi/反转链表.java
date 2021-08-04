package jianzhi;

import base.ListNode;

public class 反转链表 {
    public ListNode reverseList(ListNode head) {

        //  当head当前节点为空时，什么都不做
        if (head == null) {
            return null;
        }

        //  pre节点：用来存储上一个节点链接
        ListNode pre = null;
        //  next节点：用来存储下一个节点链接
        ListNode next = null;

        //  当前节点不为空时
        while (head != null) {

            //  交换
            next = head.next;
            head.next = pre;

            //  移动
            pre = head;
            head = next;
        }

        //  反转后，第一个节点即为链表的表头
        return pre;
    }
}
