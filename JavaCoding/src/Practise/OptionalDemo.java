package Practise;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        OptionalDemo o = new OptionalDemo();
        o.noNullExceptionWithOptionalClass();
    }

    public void noNullExceptionWithOptionalClass() {
        String s[] = new String[5];
        String value = "";
//here ofNullable method check weather the give object is null or not if null it returns an empty Optional object or else passed argument is returned
        s[2]="hello";
        Optional<String> checkNull = Optional.ofNullable(s[2]);
        if (checkNull.isPresent()) {
            System.out.println(checkNull.get().toUpperCase());
        } else {
            System.out.println("string value is not present");
        }
    }

    public void nullExceptionWithOutOptionalClass() {
        String s[] = new String[5];
        String value = s[2].toUpperCase();
        System.out.println(value);
    }
}
