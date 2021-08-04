package jianzhi;

import base.TreeLinkNode;

import java.util.ArrayList;

public class 二叉树的下一个结点 {

    public TreeLinkNode GetNext_2(TreeLinkNode pNode) {
        if (pNode == null) {
            return pNode;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }

    public TreeLinkNode GetNext_1(TreeLinkNode pNode) {
        TreeLinkNode pRoot = pNode;
        while (pRoot.next != null) {
            pRoot = pRoot.next;
        }
        ArrayList<TreeLinkNode> list = new ArrayList<>();
        getMiddleList(list, pRoot);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == pNode && (i + 1 < list.size())) {
                return list.get(i + 1);
            }
        }
        return null;
    }

    public void getMiddleList(ArrayList<TreeLinkNode> list, TreeLinkNode pNode) {
        if (pNode == null) {
            return;
        }
        getMiddleList(list, pNode.left);
        list.add(pNode);
        getMiddleList(list, pNode.right);
    }
}
