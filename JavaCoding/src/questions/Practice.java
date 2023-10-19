package questions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("CPUR02_ARP_2_20231019(\\d*).txt");
        boolean matches = pattern.matcher("CPUR02_ARP_2_20231019adf123456.txt").matches();
        System.out.println(matches);
    }


}