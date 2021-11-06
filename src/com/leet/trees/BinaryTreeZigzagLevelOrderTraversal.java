package com.leet.trees;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (q.size() > 0) {
            int n = q.size();
            List<Integer> intermediate = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode temp = q.poll();

                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);

                intermediate.add(temp.val);
            }

            if (result.size() % 2 != 0) Collections.reverse(intermediate);
            result.add(intermediate);
        }

        return result;
    }
}