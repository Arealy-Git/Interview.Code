package top200;

import base.TreeNode;

public class t42_平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right)
                && (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(
                maxDepth(root.left),
                maxDepth(root.right));
    }

}
