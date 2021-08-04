package jianzhi;

import base.TreeNode;

public class 二叉搜索树与双向链表 {
    public TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.right);
        if (pre != null) {
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.left);
        return pre;
    }
}
