package jianzhi;

import base.TreeNode;

public class 序列化二叉树 {
    //前序遍历
    public String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    int index = -1;
    //反前序遍历
    public TreeNode Deserialize(String str) {
        index++;
        String[] strs = str.split(",");
        TreeNode node = null;

        if (!"#".equals(strs[index])) {
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
