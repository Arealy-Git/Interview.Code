package jianzhi;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 对称的二叉树 {

    boolean isSymmetrical_2(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot.left);
        queue.add(pRoot.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    public boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.left == right.right
                && isSymmetrical(left.left, right.right)
                && isSymmetrical(left.right, right.left);
    }

}
