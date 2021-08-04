package jianzhi;

public class 二叉搜索树的后序遍历序列 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end], split = start;
        for (int i = start; i < end; i++) {
            if (sequence[i] < root) {
                split++;
            } else {
                break;
            }
        }

        for (int i = split; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }

        return isBST(sequence, start, split - 1)
                && isBST(sequence, split, end - 1);
    }

}
