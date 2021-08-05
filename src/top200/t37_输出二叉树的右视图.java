package top200;

import base.TreeNode;

import java.util.*;

public class t37_输出二叉树的右视图 {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public int[] solve(int[] xianxu, int[] zhongxu) {
        TreeNode root = getTree(xianxu, zhongxu);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int cur = 0, all = queue.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            path.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            cur++;
            if (cur == all) {
                cur = 0;
                all = queue.size();
                result.add(new ArrayList<>(path));
                path.clear();
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i).get(result.get(i).size() - 1);
        }
        return res;
    }

    public TreeNode getTree(int[] xianxu, int[] zhongxu) {
        if (xianxu == null || zhongxu == null
                || xianxu.length == 0 || zhongxu.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode((xianxu[0]));
        for (int i = 0; i < zhongxu.length; i++) {
            if (xianxu[0] == zhongxu[i]) {
                node.left = getTree(
                        Arrays.copyOfRange(xianxu, 1, i + 1),
                        Arrays.copyOfRange(zhongxu, 0, i));
                node.right = getTree(Arrays.copyOfRange(xianxu, i + 1, xianxu.length),
                        Arrays.copyOfRange(zhongxu, i + 1, zhongxu.length));
            }
        }
        return node;
    }

}
