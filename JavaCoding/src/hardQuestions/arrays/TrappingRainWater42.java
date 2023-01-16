package hardQuestions.arrays;

import java.util.Arrays;

public class TrappingRainWater42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        int len = height.length;
        int[] leftWall = new int[len];
        int[] rightWall = new int[len];

        int wallHeight = 0;

        for (int i = 0; i < len; i++) {
            if (height[i] > wallHeight) {
                wallHeight = height[i];
                leftWall[i] = wallHeight;
            } else {
                leftWall[i] = wallHeight;
            }
        }

        wallHeight = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (height[i] > wallHeight) {
                wallHeight = height[i];
                rightWall[i] = wallHeight;
            } else {
                rightWall[i] = wallHeight;
            }
        }
        int n = 0, sum = 0;

        while (n < len) {
            sum += Math.min(leftWall[n], rightWall[n]) - height[n];
            n++;
        }
        return sum;
    }
}
