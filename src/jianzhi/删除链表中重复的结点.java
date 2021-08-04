package jianzhi;

import base.ListNode;

import java.util.ArrayList;
import java.util.HashMap;

public class 删除链表中重复的结点 {
    public ListNode deleteDuplication_1(ListNode pHead) {
        // 只有0个或1个结点，则返回
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 当前结点是重复结点
        if (pHead.val == pHead.next.val) {
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            // 从第一个与当前结点不同的结点开始递归
            return deleteDuplication_1(pNode);
        }
        // 当前结点不是重复结点
        else {
            // 保留当前结点，从下一个结点开始递归
            pHead.next = deleteDuplication_1(pHead.next);
            return pHead;
        }
    }

    public ListNode deleteDuplication_2(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode p = pHead;
        while (p != null) {
            if (map.containsKey(p.val)) {
                map.put(p.val, map.get(p.val) + 1);
            } else {
                map.put(p.val, 1);
            }
            p = p.next;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        p = pHead;
        while (p != null) {
            if (map.get(p.val) == 1) {
                list.add(new ListNode(p.val));
            }
            p = p.next;
        }

        if (list.size() == 0) {
            return null;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }

        return list.get(0);
    }
}
