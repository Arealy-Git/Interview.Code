package top200;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的之字形层序遍历 {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> layer = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1, cur = 0, all = queue.size();
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            layer.add(node.val);
            cur++;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            if (cur == all) {
                cur = 0;
                all = queue.size();
                if (level % 2 == 1) {
                    layer = reverseArrayList(layer);
                }
                level++;
                result.add(layer);
                layer = new ArrayList<>();
            }
        }
        return result;
    }

    public ArrayList<Integer> reverseArrayList(ArrayList<Integer> arrayList) {
        ArrayList<Integer> reverse = new ArrayList<>();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            reverse.add(arrayList.get(i));
        }
        return reverse;
    }
}
