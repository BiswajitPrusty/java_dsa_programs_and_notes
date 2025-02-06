package questions.arrays;

public class TrappingRainWater42 {


    public static int maxArea2(int[] height) {

        int l = 0, r = height.length - 1, maxArea = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[r], height[l]);
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r]) {
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int trap(int[] height) {
        int len = height.length;
        int[] leftWall = new int[len];
        int[] rightWall = new int[len];

        int leftWallHeight = 0;
        int rightWallHeight = 0;
        for (int i = 0, j = len - 1; i < len & len >= 0; i++, j--) {
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
