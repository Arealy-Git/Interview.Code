package leetcode;

import base.TreeNode;

import java.util.ArrayList;

public class 层数最深叶子节点的和 {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getTreePath(root, path);
        int max = getTreeMaxDepth(root), sum = 0;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).size() == max) {
                sum += result.get(i).get(max);
            }
        }
        return sum;
    }

    public int getTreeMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getTreeMaxDepth(root.left), getTreeMaxDepth(root.right));
    }

    public void getTreePath(TreeNode root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        getTreePath(root.left, path);
        getTreePath(root.right, path);
        path.remove(path.size() - 1);
    }
}
