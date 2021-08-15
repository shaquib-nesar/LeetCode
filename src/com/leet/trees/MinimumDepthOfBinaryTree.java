package com.leet.trees;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;
        return getMin(root);
    }

    public int getMin(TreeNode n) {
        if (n.left == null && n.right == null)
            return 1;

        if (n.left == null)
            return 1 + getMin(n.right);

        if (n.right == null)
            return 1 + getMin(n.left);

        return 1 + Math.min(getMin(n.right), getMin(n.left));
    }
}
