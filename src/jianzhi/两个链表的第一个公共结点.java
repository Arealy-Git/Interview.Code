package jianzhi;

import base.ListNode;

import java.util.HashMap;

public class 两个链表的第一个公共结点 {

    //利用HashMap的特性
    public ListNode FindFirstCommonNode_1(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;

        HashMap<ListNode, Integer> map = new HashMap<>();
        while (current1 != null) {
            map.put(current1, null);
            current1 = current1.next;
        }
        while (current2 != null) {
            if (map.containsKey(current2)) {
                return current2;
            }
            current2 = current2.next;
        }
        return null;
    }

    //模拟
    public ListNode FindFirstCommonNode_2(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;

        if (pHead1 != null || pHead2 != null) {
            return null;
        }
        int length1 = getLength(current1);
        int length2 = getLength(current2);

        int len = Math.abs(length1 - length2);
        while (len > 0) {
            if (length1 >= length2) {
                current1 = current1.next;
            } else {
                current2 = current2.next;
            }
            len--;
        }

        while (current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;
        }

        return current1;
    }

    public int getLength(ListNode pHead) {
        int length = 0;
        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
