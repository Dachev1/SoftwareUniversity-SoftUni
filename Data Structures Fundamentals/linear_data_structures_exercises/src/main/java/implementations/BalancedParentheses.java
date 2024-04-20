package implementations;

import interfaces.Solvable;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        while (true) {
            if (parentheses.contains("()")) {
                parentheses = parentheses.replace("()", "");
            } else if (parentheses.contains("{}")) {
                parentheses = parentheses.replace("{}", "");
            } else if (parentheses.contains("[]")) {
                parentheses = parentheses.replace("[]", "");
            } else {
                return parentheses.isEmpty();
            }
        }
    }
}

