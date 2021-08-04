package jianzhi;

import base.TreeNode;

import java.util.ArrayList;

public class 二叉搜索树的第k个结点 {

    int index = 0;

    //中序遍历
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode leftNode = KthNode(pRoot.left, k);
            if (leftNode != null) {
                return leftNode;
            }

            index++;
            if (index == k) {
                return pRoot;
            }

            TreeNode rightNode = KthNode(pRoot.right, k);
            if (rightNode != null) {
                return rightNode;
            }
        }
        return null;
    }

    ArrayList<TreeNode> list = new ArrayList<>();

    public TreeNode KthNode_1(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        GetTreeList(pRoot);
        return list.size() < k ? null : list.get(k - 1);
    }

    public void GetTreeList(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        GetTreeList(pRoot.left);
        list.add(pRoot);
        GetTreeList(pRoot.right);
    }

}
