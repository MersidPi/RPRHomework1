package ba.unsa.etf.rpr;

/**
 * Entry point to ExpressionEvaluator class that implements Dijkstra's Algorithm for expression evaluation
 * This is a console application, it accepts one string argument in which should be expression
 * that needs to be evaluated, if it's valid, it returns correct result
 * @author Mersid Pilipović
 */
public class App {
    /**
     * Main function of the program
     * @param args in this parameter first element should be input string from console
     */
    public static void main( String[] args ) {
        System.out.println("\n\n---------------------------------------------------------------------\n" +
                "Make sure that the input expression is one parameter and in form of examples:" +
                "\n\"( 6 * 3 )\",  \"( ( 6 * sqrt ( 8 ) ) - ( 5 / 6 ) )\",  \"sqrt ( 3 )\""   +
                "\n\"( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )\",  \"sqrt ( ( 70 - 6 ) )\" "+
                "\nIf you don't follow these forms of expression, result may not be correct or exception will be thrown.");

        if (args.length == 0) {
            throw new RuntimeException("Expression not provided");
        }
        isValid(args[0]);
        System.out.println("\nEvaluating expression with Dijkstra's Algorithm..." +
                "\nResult: " + args[0] + " = " + ExpressionEvaluator.evaluate(args[0]));

        System.out.println("---------------------------------------------------------------------\n");
    }

    /**
     * Checks if input is valid expression, in contrary, throws exception
     * @param input input string
     */
    private static void isValid(String input) {
        for (String str : input.split(" ")) {
            boolean isOperator = "(+-*/sqrt)".contains(str);
            if (str.isEmpty()) {
                throw new RuntimeException("Expression not valid");
            }
            if (!isOperator) {
                try {
                    Double.parseDouble(str);
                }
                catch (Exception e) {
                    throw new RuntimeException("Expression not valid");
                }
            }
        }
    }

}
