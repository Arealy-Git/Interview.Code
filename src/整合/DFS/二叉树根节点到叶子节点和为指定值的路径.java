package 整合.DFS;

import base.TreeNode;

import java.util.*;

public class 二叉树根节点到叶子节点和为指定值的路径 {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null || sum == 0) {
            return result;
        }
        DFS(root, sum);
        return result;
    }

    private void DFS(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        path.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        DFS(root.left, sum);
        DFS(root.right, sum);
        path.remove(path.size() - 1);
    }

}
