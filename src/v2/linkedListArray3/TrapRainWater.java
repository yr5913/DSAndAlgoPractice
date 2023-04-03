package v2.linkedListArray3;

public class TrapRainWater {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int currentMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = currentMax;
            currentMax = Math.max(height[i], currentMax);
        }
        currentMax = 0;
        int water = 0;
        for (int i = height.length - 1; i > 0; i--) {
            int minOfLeftRightMaxes = Math.min(currentMax, leftMax[i]);
            if (minOfLeftRightMaxes > height[i]) {
                water += (minOfLeftRightMaxes - height[i]);
            }
            currentMax = Math.max(height[i], currentMax);
        }
        return water;
    }
}
