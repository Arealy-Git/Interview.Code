package top200;

import base.TreeNode;

import java.util.*;

public class t51_二叉树和为指定值的路径 {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        dfs(root);
        for (int i = 0; i < result.size(); i++) {
            int target = 0;
            for (int j = 0; j < result.get(i).size(); j++) {
                target += result.get(i).get(j);
            }
            if (target == sum) {
                res.add(result.get(i));
            }
        }
        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        }
        dfs(node.left);
        dfs(node.right);
        path.remove(path.size() - 1);
    }

}
