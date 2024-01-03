package questions.strings;

public class RobotReturnOrigin657 {

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
    }
    public static boolean judgeCircle(String moves) {
        int xAxis = 0, yAxis = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                yAxis++;
            } else if (moves.charAt(i) == 'D') {
                yAxis--;
            } else if (moves.charAt(i) == 'L') {
                xAxis++;
            } else if (moves.charAt(i) == 'R') {
                xAxis--;
            }
        }
        return xAxis == 0 && yAxis == 0;
    }
}
