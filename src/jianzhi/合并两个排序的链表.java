package jianzhi;

import base.ListNode;

public class 合并两个排序的链表 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode current = null;
        ListNode mergeHead = null;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (mergeHead == null) {
                    mergeHead = list1;
                    current = list1;
                } else {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            } else {
                if (mergeHead == null) {
                    mergeHead = list2;
                    current = list2;
                } else {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return mergeHead;
    }
}