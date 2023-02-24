package questions.arrays;

public class TrappingRainWater42 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        int len = height.length;
        int[] leftWall = new int[len];
        int[] rightWall = new int[len];

        int leftWallHeight = 0;
        int rightWallHeight = 0;
        for (int i = 0, j = len - 1; i < len & len >=0; i++, j--) {
            if (height[i] > leftWallHeight) {
                leftWallHeight = height[i];
                leftWall[i] = leftWallHeight;
            } else {
                leftWall[i] = leftWallHeight;
            }

            if (height[j] > rightWallHeight) {
                rightWallHeight = height[j];
                rightWall[j] = rightWallHeight;
            } else {
                rightWall[j] = rightWallHeight;
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
