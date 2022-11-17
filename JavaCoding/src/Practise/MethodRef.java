package Practise;

@FunctionalInterface
interface I {
    public void add(int x, int y);
}

class A {
    public static void addition(int a, int b) {
        System.out.println("the value of addition is " + (a + b));
    }
}

public class MethodRef {
    public static void main(String[] args) {
        I obj = A::addition;
        obj.add(2,3);
    }
}
