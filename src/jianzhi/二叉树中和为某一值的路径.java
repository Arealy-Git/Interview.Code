package jianzhi;

import base.TreeNode;

import java.util.ArrayList;

public class 二叉树中和为某一值的路径 {

    ArrayList<Integer> path = new ArrayList<>();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        path.add(root.val);
        target -= root.val;

        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }

        FindPath(root.left, target);
        FindPath(root.right, target);

        path.remove(path.size() - 1);

        return result;
    }

}
