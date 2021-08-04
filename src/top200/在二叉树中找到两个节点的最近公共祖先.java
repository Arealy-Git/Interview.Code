package top200;

import base.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class 在二叉树中找到两个节点的最近公共祖先 {

    HashMap<Integer, TreeNode> parent = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        dfs(root);

        visited.add(o1);
        while (parent.get(o1) != null) {
            visited.add(parent.get(o1).val);
            o1 = parent.get(o1).val;
        }

        while (!visited.contains(o2)) {
            o2 = parent.get(o2).val;
        }

        return o2;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                parent.put(root.left.val, root);
                dfs(root.left);
            }
            if (root.right != null) {
                parent.put(root.right.val, root);
                dfs(root.right);
            }
        }
    }

}
