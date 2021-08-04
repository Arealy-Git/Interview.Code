package jianzhi;

import base.TreeNode;
import java.util.ArrayList;

public class 二叉树的深度 {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        getTreeDepth(root, path, result);
        int max = 0;
        for (int i = 0; i < result.size(); i++) {
            path = result.get(i);
            if (path.size() > max) {
                max = path.size();
            }
        }
        return max;
    }

    public void getTreeDepth(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            getTreeDepth(root.left, path, result);
        }
        if (root.right != null) {
            getTreeDepth(root.right, path, result);
        }
        path.remove(path.size() - 1);
    }
}
