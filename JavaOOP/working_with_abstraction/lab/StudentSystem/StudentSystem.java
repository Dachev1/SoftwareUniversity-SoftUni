package working_with_abstraction.lab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }
    public void parseCommand(String... args) {
        var name = args[1];
        if (args[0].equals("Create")) {
            var age = Integer.parseInt(args[2]);
            var grade = Double.parseDouble(args[3]);
            var student = new Student(name, age, grade);
            repo.putIfAbsent(name, student);
        } else if (args[0].equals("Show")) {
            if (repo.containsKey(name)) {
                var student = repo.get(name);

                StringBuilder sb = new StringBuilder();
                sb.append(String.format("%s is %s years old.", student.getName(), student.getAge()));

                if (student.getGrade() >= 5.00) {
                    sb.append(" Excellent student.");
                } else if (student.getGrade() >= 3.50) {
                    sb.append(" Average student.");
                } else {
                    sb.append(" Very nice person.");
                }

                System.out.println(sb);
            }
        }
    }
}
