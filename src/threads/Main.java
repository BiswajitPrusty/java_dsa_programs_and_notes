package threads;

public class Main {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            System.out.println("hello world");
            System.out.println("thread Name " + Thread.currentThread().getName());

        });

        System.out.println("thread Name " + Thread.currentThread().getName());
        thread.start();

        System.out.println("thread Name " + Thread.currentThread().getName());

    }


}
