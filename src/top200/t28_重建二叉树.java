package top200;

import base.TreeNode;

import java.util.*;

public class t28_重建二叉树 {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                node.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(in, 0, i)
                );
                node.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length)
                );
            }
        }
        return node;
    }

}
