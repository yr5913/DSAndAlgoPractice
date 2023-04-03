package v2.stackandqueue2;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {

    int[][] stack = new int[10000][2];
    int current = -1;

    List<int[]> list = new ArrayList<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int[] arr = new int[2];
        arr[1] = 1;
        while (!list.isEmpty() && list.get(list.size()-1)[0] <= price) {
            arr[1] += list.remove(list.size()-1)[1];
        }
        arr[0] = price;
        list.add(arr);
        return arr[1];
    }
}
