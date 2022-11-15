package ba.unsa.etf.rpr;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        /*System.out.println("Evaluating expression with Dijkstra's Algorithm");
        System.out.println("Examples of expression: ( 2 + 3 ), ( 5 * ( 6 * sqrt ( 3 ) ) )");
        System.out.println("Enter expression:");*/
        System.out.println("Evaluating expression with Dijkstra's Algorithm...");
        StringBuilder expression = new StringBuilder(new String());
        for (String arg : args) {
            if (arg.equals("'*")) {
                expression.append("* ");
            }
            else {
                expression.append(arg).append(" ");
            }
        }
        System.out.println("Result: " + ExpressionEvaluator.evaluate(expression.toString()));
    }
}
