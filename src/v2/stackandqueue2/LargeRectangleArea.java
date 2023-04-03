package v2.stackandqueue2;


public class LargeRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int area = 0;
        int[] left = new int[heights.length];
        int[] stack = new int[heights.length];
        int stackIndex = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stackIndex == 0) {
                left[i] = i;
            } else {
                int index = -1;
                while (stackIndex != 0 && heights[stack[stackIndex - 1]] >= heights[i]) {
                    index = stack[--stackIndex];
                    area = Math.max(area, (i - left[index]) * heights[index]);
                }
                if (index == -1) {
                    left[i] = i;
                } else {
                    left[i] = left[index];
                }
            }
            stack[stackIndex++] = i;
        }
        while (stackIndex != 0) {
            int index = stack[--stackIndex];
            area = Math.max(area, (heights.length - left[index]) * heights[index]);
        }
        return area;
    }
}

