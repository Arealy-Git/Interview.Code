package top200;

import base.ListNode;

import java.util.Stack;

public class 链表中的节点每k个一组翻转 {

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode ret = new ListNode(0);
        ListNode p = ret;

        while (true) {
            int count = 0;
            ListNode temp = head;
            while (temp != null && count < k) {
                count++;
                stack.push(temp);
                temp = temp.next;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }
            head = temp;
        }

        return ret.next;
    }

}
