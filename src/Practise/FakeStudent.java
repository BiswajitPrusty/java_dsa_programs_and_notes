package Practise;

import java.util.Objects;

public class FakeStudent extends  Student{
    private  String fakeName;
    public FakeStudent(String name) {
        super(name);
        this.fakeName = name;
    }
    //as this method is overriden so by using fake name hashcode is calculated
//    and the Student class property of immutablity is gone
    @Override
    public String getName() {
        return fakeName;
    }

    public void setFakeName(String fakeName) {
        this.fakeName = fakeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FakeStudent that = (FakeStudent) o;
        return Objects.equals(fakeName, that.fakeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fakeName);
    }
}
