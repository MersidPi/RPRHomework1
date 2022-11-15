package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    private static Stack<String> operators;
    private static Stack<Double> values;

    private static boolean getOperator (String str) {
        for (String s : "+ - * / sqrt".split(" ")) {
            if (s.equals(str)) {
                operators.push(str);
                return true;
            }
        }
        return false;
    }

    private static void doOperation () {
        String operator = operators.pop();
        double value = values.pop();
        switch (operator) {
            case "+":
                value = values.pop() + value;
                break;
            case "-":
                value = values.pop() - value;
                break;
            case "*":
                value = values.pop() * value;
                break;
            case "/":
                value = values.pop() / value;
                break;
            case "sqrt":
                value = Math.sqrt(value);
                break;
        }
        values.push(value);
    }

    private static boolean isInputValid (String inputString) {
        return true;
    }

    public static Double evaluate(String inputString) {
        operators = new Stack<String>();
        values = new Stack<Double>();
        for (String str : inputString.split(" ")) {
            if (getOperator(str) || str.equals("(")) {
                continue;
            }
            if (str.equals(")")) {
                doOperation();
            }
            else if (!str.isEmpty()) {
                values.push(Double.parseDouble(str));
            }
        }
        return values.pop();
    }
}
