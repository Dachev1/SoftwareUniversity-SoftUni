package DefiningClasses.Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Department {
    private int n;
    private List<Employee> departmentInfo;

    public Department(int count) {
        this.n = count;
        this.departmentInfo = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (departmentInfo.size() <= n) {
            departmentInfo.add(employee);
        }
    }

    public void getDepartmentHighestAverageSalary() {

        Map<String, List<Employee>> departmentsMap = this.departmentInfo.stream()
                .collect(groupingBy(Employee::getDepartment));


        Map.Entry<String, List<Employee>> highestSalaryDepartment = departmentsMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> {
                    double entry1AvgSalary = entry1.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();

                    double entry2AvgSalary = entry2.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();

                    return Double.compare(entry2AvgSalary, entry1AvgSalary);
                })
                .findFirst()
                .orElse(null);

        System.out.printf("Highest Average Salary: %s\n", highestSalaryDepartment.getKey());
        highestSalaryDepartment.getValue()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
