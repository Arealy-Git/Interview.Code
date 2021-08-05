package top200;

import base.ListNode;

import java.util.*;

public class t48_判断一个链表是否为回文结构 {

    public boolean isPail(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < arr.size() - i - 1; i++) {
            if (!arr.get(i).equals(arr.get(arr.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }

}
