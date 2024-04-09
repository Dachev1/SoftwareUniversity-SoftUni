package encapsulation.lab.sort_by_name_and_age;

public class Person {
    private final String PRINT_FORMAT = "%s %s is %d years old.";
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format(PRINT_FORMAT, this.getFirstName(), this.lastName, this.getAge());
    }
}
