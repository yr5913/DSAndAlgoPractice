package v2.myPractice;

public class ContainerWater {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            int newArea = (right - left) * Math.min(height[left], height[right]);
            area = Math.max(area, newArea);
            if (height[left] < height[right]) {
                left ++;
            } else {
                right--;
            }
        }

        return area;
    }
}
