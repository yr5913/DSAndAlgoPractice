package exam4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 {

    public static void main(String[] args) {
        Integer[] x= {-3,0,2,1};
        maxPosPrefixes(new ArrayList<>(Arrays.asList(x)));
    }


    public static int maxPosPrefixes(List<Integer> arr) {

        arr.sort(Integer::compareTo);
        long sum = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            sum += arr.get(i);
            if (sum <= 0)
                return arr.size() - i - 1;
        }
        return arr.size();
    }
}
