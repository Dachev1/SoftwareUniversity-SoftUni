package ExamPreparation.August_18_2021.Cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }

        return false;
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        Employee employee = null;

        for (Employee e : this.employees) {
            if (e.getName().equals(name)) {
                employee = e;
                return employee;
            }
        }

        return employee;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Employees working at ExamPreparation.August_18_2021.Cafe %s:", this.name));
        sb.append(System.lineSeparator());

        for (Employee employee : this.employees) {
            sb.append(employee);
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
