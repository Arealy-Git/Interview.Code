package top200;

import base.ListNode;

public class t41_单链表的排序 {

    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode move = head;
        while (move.next != null) {
            ListNode temp = move.next;
            while (temp != null) {
                if (temp.val < move.val) {
                    int val = temp.val;
                    temp.val = move.val;
                    move.val = val;
                }
                temp = temp.next;
            }
            move = move.next;
        }
        return head;
    }
    
}
