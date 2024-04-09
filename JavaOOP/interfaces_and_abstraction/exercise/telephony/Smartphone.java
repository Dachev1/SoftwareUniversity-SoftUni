package interfaces_and_abstraction.exercise.telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.numbers) {
            if (number.matches("\\d+")) {
                sb.append(String.format("Calling... %s", number));
                sb.append(System.lineSeparator());
            } else {
                sb.append("Invalid number!");
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String site : this.urls) {
            if (site.matches("\\D+")) {
                sb.append(String.format("Browsing: %s!", site));
                sb.append(System.lineSeparator());
            } else {
                sb.append("Invalid URL!");
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
