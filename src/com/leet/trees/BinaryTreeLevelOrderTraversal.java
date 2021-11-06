package com.leet.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

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
            result.add(intermediate);
        }

        return result;
    }
}