package v2.myPractice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FrequencySort {

    public String frequencySort(String s) {

        int[][] x = new int[66][2];
        char[] chars = s.toCharArray(); // 57 97
        for (char current : chars) {
            if (current > 96) {
                x[current - 'a'][0]++;
                x[current - 'a'][1] = current;
            } else if (current < 58) {
                x[current - '0' + 26][0]++;
                x[current - '0' + 26][1] = current;
            } else {
                x[current - 'A' + 36][0]++;
                x[current - 'A' + 36][1] = current;
            }


        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((x1, x2) -> x2[0] - x1[0]);
        for(int i=0;i<x.length;i++){
            if(x[i][0]!=0)
            queue.add(x[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            int []  arr = queue.remove();
            char current = (char) arr[1];
            for (int j = 0; j < arr[0]; j++) {
                sb.append(current);
            }
        }
        return sb.toString();
    }


}
