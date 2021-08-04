package jianzhi;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 二叉树的镜像 {
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }

        pRoot = exchange(pRoot);

        return pRoot;
    }

    public TreeNode exchange(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }

        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;

        pRoot.left = exchange(pRoot.left);
        pRoot.right = exchange(pRoot.right);

        return pRoot;
    }

    public static TreeNode treeBFS(TreeNode pRoot) {
        if (null == pRoot) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return pRoot;
    }

    public static TreeNode treeDFS(TreeNode pRoot) {
        if (null == pRoot) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return pRoot;
    }

    public static TreeNode recursion(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        recursion(pRoot.left);

        TreeNode node = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = node;

        recursion(pRoot.right);

        return pRoot;
    }
}
