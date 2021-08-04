package jianzhi;

import base.TreeNode;

public class 树的子结构 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || (root1 == null && root2 != null)) {
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val) {
            result = isSubTree(root1, root2);
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean isSubTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null && node2 != null) {
            return false;
        }
        if (node1.val == node2.val) {
            return isSubTree(node1.left, node2.left)
                    && isSubTree(node1.right, node2.right);
        }
        return false;
    }

}
