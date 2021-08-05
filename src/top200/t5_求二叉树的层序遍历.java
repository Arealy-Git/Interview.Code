package top200;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class t5_求二叉树的层序遍历 {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int cur = 0, all = queue.size();
        while (!queue.isEmpty()) {
            ArrayList<Integer> layer = new ArrayList<>();
            while (cur < all) {
                cur++;
                TreeNode node = queue.poll();
                layer.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (cur == all) {
                cur = 0;
                all = queue.size();
                result.add(layer);
            }
        }
        return result;
    }

}
