package top200;

import base.TreeNode;

import java.util.*;

public class t4_实现二叉树先中后序遍历 {

    public int[][] threeOrders(TreeNode root) {
        ArrayList<Integer> dlr = new ArrayList<>();
        ArrayList<Integer> ldr = new ArrayList<>();
        ArrayList<Integer> lrd = new ArrayList<>();

        DLR(root, dlr);
        LDR(root, ldr);
        LRD(root, lrd);

        int[][] threeOrders = new int[3][dlr.size()];
        for (int i = 0; i < dlr.size(); i++) {
            threeOrders[0][i] = dlr.get(i);
            threeOrders[1][i] = ldr.get(i);
            threeOrders[2][i] = lrd.get(i);
        }

        return threeOrders;
    }

    private void DLR(TreeNode root, ArrayList<Integer> dlr) {
        if (root == null) {
            return;
        }
        dlr.add(root.val);
        DLR(root.left, dlr);
        DLR(root.right, dlr);
    }

    private void LDR(TreeNode root, ArrayList<Integer> ldr) {
        if (root == null) {
            return;
        }
        LDR(root.left, ldr);
        ldr.add(root.val);
        LDR(root.right, ldr);
    }

    private void LRD(TreeNode root, ArrayList<Integer> lrd) {
        if (root == null) {
            return;
        }
        LRD(root.left, lrd);
        LRD(root.right, lrd);
        lrd.add(root.val);
    }

}
