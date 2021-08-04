package jianzhi;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 把二叉树打印成多行 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> rows;

        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        int current = 0, currentAll = queue.size();
        while (!queue.isEmpty()) {
            rows = new ArrayList<>();
            while (current < currentAll) {
                current++;
                TreeNode node = queue.poll();
                if (node != null) {
                    rows.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!rows.isEmpty()) {
                current = 0;
                currentAll = queue.size();
                result.add(rows);
            }
        }

        return result;
    }
}
