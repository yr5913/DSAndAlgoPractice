package arrays1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> pascalList = new ArrayList<>();
        List<Integer> lastList = null;
        if(numRows>0){
            List<Integer> singleList = new ArrayList<>();
            singleList.add(1);
            pascalList.add(singleList);
        }
        if(numRows>1){
            List<Integer> singleList = new ArrayList<>();
            singleList.add(1);
            singleList.add(1);
            pascalList.add(singleList);
            lastList = singleList;
        }
        for(int i=3;i<=numRows;i++){
            List<Integer> singleList = new ArrayList<>();
            singleList.add(1);
            for(int j=0;j<lastList.size()-1;j++){
                singleList.add(lastList.get(j)+lastList.get(j+1));
            }
            singleList.add(1);
            pascalList.add(singleList);
            lastList = singleList;
        }
        return pascalList;
    }

    public List<List<Integer>> generateBetterCoded(int numRows){
        List<List<Integer>> pascalList = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            row.add(1);
            for(int j=row.size()-2;j>0;j--){
                row.set(j, row.get(j-1) + row.get(j));
            }
            pascalList.add(new ArrayList<>(row));
        }
        return pascalList;
    }

    public static void main(String[] args) {
        new PascalTriangle().generateBetterCoded(4);
    }
}
