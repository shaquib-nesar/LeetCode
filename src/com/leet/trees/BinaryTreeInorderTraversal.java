package com.leet.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorderIterative(root, result);
        return result;
    }

    public static void inorderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) return;

        inorderRecursive(node.left, result);
        result.add(node.val);
        inorderRecursive(node.right, result);
    }

    public static void inorderIterative(TreeNode node, List<Integer> result) {
        if (node == null) return;

        TreeNode curr = node;
        Stack<TreeNode> stack = new Stack<>();

        while (stack.size() > 0 || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.pop();
                result.add(temp.val);
                curr = temp.right;
            }
        }
    }
}