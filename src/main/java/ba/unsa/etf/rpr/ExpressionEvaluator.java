package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Class that implements Dijkstra's algorithm for expression evaluation using two stacks
 * @author Mersid Pilipović
 */
public class ExpressionEvaluator {
    private static final Stack<String> operators = new Stack<>();
    private static final Stack<Double> values = new Stack<>();

    /**
     * Method for adding operator to stack 'operators'
     * @param str a string based on which we identify the operator
     * @return true if operator was successfully added to stack, in contrary returns false
     */
    private static boolean getOperator (String str) {
        if ("+-*/sqrt".contains(str) && !str.isEmpty()) {
            operators.push(str);
            return true;
        }
        return false;
    }

    /**
     * Method for doing operation that was last added on stack 'operators'
     * Updates value in stack 'values', after doing the operation
     */
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

    /**
     * Method for testing if input string is valid by the rules of expression formation
     * @param inputString string for validation
     * @return true if valid, in contrary false
     */
    private static boolean isInputValid (String inputString) {
        for (String str : inputString.split(" ")) {
            boolean isOperator = "(+-*/sqrt)".contains(str);
            if (str.isEmpty()) {
                return false;
            }
            if (!isOperator) {
                try {
                    Double.parseDouble(str);
                }
                catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Main method of the class, evaluates expression that was accepted in parameter
     * @param inputString string which contains expression
     * @return value of evaluated expression
     * @throws RuntimeException if expression isn't valid
     */
    public static Double evaluate(String inputString) throws RuntimeException {
        if (!isInputValid(inputString)) {
            throw new RuntimeException("Expression not valid");
        }
        for (String str : inputString.split(" ")) {
            if (getOperator(str) || str.equals("(")) {
                continue;
            }
            if (str.equals(")")) {
                try {
                    doOperation();
                }
                catch (Exception e) {
                    throw new RuntimeException("Expression not valid");
                }
            }
            else if (!str.isEmpty()) {
                values.push(Double.parseDouble(str));
            }
            else {
                throw new RuntimeException("Expression not valid");
            }
        }
        return values.pop();
    }
}
