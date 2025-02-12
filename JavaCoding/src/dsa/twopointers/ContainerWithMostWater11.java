package dsa.twopointers;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {

        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        maxArea2(a);
    }

    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minWall = Math.min(height[i], height[j]);
                int areaOfWater = minWall * (j - i);
                if (maxArea < areaOfWater) {
                    maxArea = areaOfWater;
                }
            }
        }
        return maxArea;
    }

    public static int maxArea2(int[] height) {
        int i = 0, j = height.length - 1, maxArea = Integer.MIN_VALUE;

        while (i < j) {
            int left = height[i];
            int right = height[j];
            int minWal = 0;
            if (left < right) {
                minWal = left * (j - i);
                i++;
            } else {
                minWal = right * (j - i);
                j--;
            }
            if (maxArea < minWal) {
                maxArea = minWal;
            }
        }

        return maxArea;
    }


}
