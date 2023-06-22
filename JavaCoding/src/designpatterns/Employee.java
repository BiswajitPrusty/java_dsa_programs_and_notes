package designpatterns;


public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private String department;

    private Employee(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.department = builder.department;
    }

    public static void main(String[] args) {
        Employee employee = new Builder()
                .firstName("Biswajit")
                .lastName("Prusty")
                .age(24)
                .department("IT")
                .build();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String department;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}


