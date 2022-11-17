package Practise;

import java.util.HashMap;

public class HashDemo {

    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();

        FakeStudent fakeStudent = new FakeStudent("Xyz");
        Student student = fakeStudent;

        map.put(student,"India");
        System.out.println(map.get(student));//India

        fakeStudent.setFakeName("Abc");
        System.out.println(map.get(student));//null


    }
}
