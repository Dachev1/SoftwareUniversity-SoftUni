package encapsulation.lab.validation_data;

public class Person {
    private final String PRINT_FORMAT = "%s %s gets %f leva";
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
       setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age must not be zero or negative");
        }

            this.age = age;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() >= 3) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Names must be at least 3 symbols");
        }
    }

    public void setLastName(String lastName) {
        if (lastName.length() >= 3) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Names must be at least 3 symbols");
        }
    }

    public void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary can't be less than 460");
        }

            this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 200));
        } else {
            this.setSalary(this.getSalary() + (this.getSalary() * bonus / 100));
        }
    }

    @Override
    public String toString() {
        return String.format(PRINT_FORMAT,
                this.firstName, this.lastName, getSalary());
    }
}
