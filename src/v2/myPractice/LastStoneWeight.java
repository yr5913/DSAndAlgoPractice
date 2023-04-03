package v2.myPractice;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> integers = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int stone : stones) {
            integers.add(stone);
        }
        while (integers.size() > 1) {
            int stone1 = integers.remove();
            int stone2 = integers.remove();
            int collision = Math.abs(stone1 - stone2);
            if (collision != 0) {
                integers.add(collision);
            }
        }

        return integers.size()!=0?integers.peek():0;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 1, 8, 1};
        new LastStoneWeight().lastStoneWeight(arr);
    }


}
