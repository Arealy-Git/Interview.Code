package leetcode;

import base.TreeNode;

import java.util.*;

public class 二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> layer = null;

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0, cur = 0, all = queue.size();
        while (!queue.isEmpty()) {
            layer = new ArrayList<>();
            while (cur < all) {
                cur++;
                TreeNode node = queue.poll();
                if (node != null) {
                    layer.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!layer.isEmpty()) {
                cur = 0;
                level++;
                all = queue.size();
                if (level % 2 == 0) {
                    Collections.reverse(layer);
                }
                result.add(layer);
            }
        }
        return result;
    }
}
