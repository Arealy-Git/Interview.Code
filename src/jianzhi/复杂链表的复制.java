package jianzhi;

import base.RandomListNode;

import java.util.HashMap;

public class 复杂链表的复制 {

    public RandomListNode Clone(RandomListNode pHead) {
        //  0、边界控制
        if (pHead == null) {
            return null;
        }

        //  1、复制结点
        RandomListNode currentNode = pHead;
        while (currentNode != null) {
            RandomListNode newNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;

            currentNode.next = newNode;
            newNode.next = nextNode;
            currentNode = nextNode;
        }

        //  2、复制指针
        currentNode = pHead;
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //  3、拆分链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null) {
            RandomListNode newNode = currentNode.next;
            currentNode.next = newNode.next;
            currentNode = currentNode.next;
            newNode.next = newNode.next == null ? null : currentNode.next;
        }

        return pCloneHead;
    }

    public RandomListNode Clone_1(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;

        while (p != null) {
            RandomListNode newNode = new RandomListNode(p.label);
            map.put(p, newNode);
            p = p.next;
        }
        p = pHead;

        while (p != null) {
            RandomListNode node = map.get(p);
            if (p.next != null) {
                node.next = map.get(p.next);
            }
            if (p.random != null) {
                node.random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(pHead);
    }

}
