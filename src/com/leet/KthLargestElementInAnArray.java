package com.leet;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.add(n);

            if (pq.size() > k)
                pq.poll();
        }

        return pq.poll();
    }

}
