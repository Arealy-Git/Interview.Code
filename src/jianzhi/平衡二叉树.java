package jianzhi;

import base.TreeNode;

public class 平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right)
                && (getTreeDepth(root.left) - getTreeDepth(root.right) <= 1);
    }

    private int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getTreeDepth(root.left), getTreeDepth(root.right)) + 1;
    }

}
