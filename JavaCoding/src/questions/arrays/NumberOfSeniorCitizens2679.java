package questions.arrays;

public class NumberOfSeniorCitizens2679 {

    public static void main(String[] args) {
        System.out.println(countSeniors(new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"}));
    }

    public static int countSeniors(String[] details) {
        int countOfSeniorCitizens = 0;
        for(String detail : details){
            int age = Integer.parseInt(detail.substring(11, 13));
            if(age > 60){
                countOfSeniorCitizens++;
            }
        }
        return countOfSeniorCitizens;
    }
}
