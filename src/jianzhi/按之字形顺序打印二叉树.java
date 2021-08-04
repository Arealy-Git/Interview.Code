package jianzhi;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 按之字形顺序打印二叉树 {
    public static ArrayList<ArrayList<Integer>> Print_2(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> rows;

        if (pRoot == null) {
            return result;
        }

        int layer = 1;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(pRoot);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            rows = new ArrayList<>();
            if (layer % 2 != 0) {
                while (!s1.isEmpty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        rows.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
            } else {
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        rows.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
            }
            if (!rows.isEmpty()) {
                layer++;
                result.add(rows);
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> Print_1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> rows;

        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        int current = 0, currentAll = queue.size(), layer = 1;
        while (!queue.isEmpty()) {
            rows = new ArrayList<>();
            while (current < currentAll) {
                current++;
                TreeNode pNode = queue.poll();
                rows.add(pNode.val);
                if (pNode.left != null) {
                    queue.add(pNode.left);
                }
                if (pNode.right != null) {
                    queue.add(pNode.right);
                }
            }
            if (layer % 2 == 0) {
                rows = Reverse(rows);
            }
            result.add(rows);
            layer++;
            current = 0;
            currentAll = queue.size();
        }

        return result;
    }

    public ArrayList<Integer> Reverse(ArrayList<Integer> rows) {
        ArrayList<Integer> rerows = new ArrayList<>();
        for (int i = rows.size() - 1; i >= 0; i--) {
            rerows.add(rows.get(i));
        }
        return rerows;
    }
}
