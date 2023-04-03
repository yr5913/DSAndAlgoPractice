package v2.heaps;

import v2.util.MyHeap;

public class MedianFinder {
    MyHeap<Integer> left = new MyHeap<>((i1, i2) -> i2 - i1);
    MyHeap<Integer> right = new MyHeap<>();
    int size = 0;
    double median = 0;

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (size == 0) {
            left.add(num);
            median = num;
        } else {
            if (size % 2 == 0) {
                if (num > right.peek()) {
                    left.add(right.remove());
                    right.add(num);
                } else {
                    left.add(num);
                }
                median = left.peek();

            } else {
                if (num < median) {
                    right.add(left.remove());
                    left.add(num);
                } else {
                    right.add(num);
                }
                median = (left.peek() + (double) right.peek()) / 2;
            }

        }
        size++;
    }

    public double findMedian() {
        return median;
    }
}