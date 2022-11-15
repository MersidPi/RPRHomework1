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
        String operator = new String();
        int parenthesisCheck = 0;
        for (String str : inputString.split(" ")) {
            boolean itIsOperator = false;
            for (String s : "( + - * / sqrt )".split(" ")) {
                if (s.equals(str)) {
                    operator = str;
                    itIsOperator = true;
                    break;
                }
            }
            if (!itIsOperator && !str.isEmpty()) {
                try {
                    Double value = Double.parseDouble(str);
                }
                catch (Exception e) {
                    return false;
                }
            }

            /*
            if (operator.equals("(")) {
                parenthesisCheck++;
            }
            else if (operator.equals(")")) {
                parenthesisCheck--;
            }
            if (parenthesisCheck > 1 || parenthesisCheck < 0) {
                System.out.println("parenthesis je " + parenthesisCheck);
                return false;
            }*/
        }
        return true;
    }

    public static Double evaluate(String inputString) throws RuntimeException {
        operators = new Stack<String>();
        values = new Stack<Double>();
        if (!isInputValid(inputString)) {
            throw new RuntimeException("Expression not valid");
        }
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
