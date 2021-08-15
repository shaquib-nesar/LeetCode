package com.leet;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    class MedianFinder {

        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;

        public MedianFinder() {
            max = new PriorityQueue<>(Comparator.reverseOrder());
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {

            if (max.size() == 0) {
                max.add(num);
                return;
            }

            if (num < max.peek()) {
                max.offer(num);
            } else {
                min.offer(num);
            }
            balanceHeap(max, min);

        }

        public double findMedian() {
            int ma = max.size();
            int mi = min.size();

            if (ma == mi) {
                return (min.peek() + (double) max.peek()) / 2;
            } else if (ma > mi) {
                return max.peek();
            } else {
                return min.peek();
            }
        }

        public void balanceHeap(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {

            int ma = max.size();
            int mi = min.size();

            if (Math.abs(ma - mi) <= 1) return;
            if (ma > mi) {
                min.offer(max.poll());
            } else {
                max.offer(min.poll());
            }
        }
    }
}
