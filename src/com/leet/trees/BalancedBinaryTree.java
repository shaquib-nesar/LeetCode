package com.leet.trees;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalancedTree(root).isBal;
    }

    public Info isBalancedTree(TreeNode node) {

        if (node == null) return new Info(0, true);

        Info l = isBalancedTree(node.left);
        Info r = isBalancedTree(node.right);

        if (l.isBal && r.isBal && Math.abs(l.dd - r.dd) <= 1)
            return new Info(Math.max(l.dd + 1, r.dd + 1), true);
        return new Info(-1, false);
    }

    public static class Info {
        public int dd;
        public boolean isBal;

        public Info(int d, boolean b) {
            dd = d;
            isBal = b;
        }
    }
}
