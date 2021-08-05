package top200;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class t57_判断一棵二叉树是否为搜索二叉树和完全二叉树 {

    public boolean[] judgeIt(TreeNode root) {
        boolean[] result = new boolean[2];
        result[0] = isSearchTree(root);
        result[1] = isCompleteTree(root);
        return result;
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (root != null) {
            root = queue.poll();
            if (root != null) {
                queue.add(root.left);
                queue.add(root.right);
            }
        }
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root != null) {
                return false;
            }
        }
        return true;
    }

    ArrayList<Integer> path = new ArrayList<>();

    public boolean isSearchTree(TreeNode root) {
        LDR(root);
        for (int i = 0; i < path.size() - 1; i++) {
            if (path.get(i) > path.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void LDR(TreeNode root) {
        if (root != null) {
            LDR(root.left);
            path.add(root.val);
            LDR(root.right);
        }
    }

}
