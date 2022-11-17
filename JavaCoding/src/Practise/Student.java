package Practise;

import java.util.Objects;

//immutable
public class Student {

    private final String name ;

    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return  this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }


}
