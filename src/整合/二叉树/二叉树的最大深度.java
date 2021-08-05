package 整合.二叉树;

import base.TreeNode;

public class 二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
