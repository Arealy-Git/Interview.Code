package jianzhi;

import base.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表 {

    //  栈—先入先出
    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arraylist = new ArrayList<>();
        while (!stack.isEmpty()) {
            arraylist.add(stack.pop());
        }
        return arraylist;
    }

    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    //  递归法
    public ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead_2(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
