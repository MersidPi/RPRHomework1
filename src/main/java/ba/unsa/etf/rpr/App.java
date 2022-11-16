package ba.unsa.etf.rpr;

/**
 * Entry point to ExpressionEvaluator class that implements Dijkstra's Algorithm for expression evaluation
 * This is a console application, it accepts one string argument in which should be expression
 * that needs to be evaluated, if it's valid, it returns correct result
 * @Author Mersid Pilipović
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("\n\n---------------------------------------------------------------------\n" +
                "Make sure that the input expression is one parameter and in form of examples:" +
                "\n\"( 6 * 3 )\",  \"( ( 6 * sqrt ( 8 ) ) - ( 5 / 6 ) )\",  \"sqrt ( 3 )\"" +
                "\n\"( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )\" "+
                "\nIf you don't follow these forms of expression, result may not be correct.");
        try {
            System.out.println("\nEvaluating expression with Dijkstra's Algorithm..." +
                    "\nResult: " + args[0] + " = " + ExpressionEvaluator.evaluate(args[0]));
        }
        catch (Exception e) {
            System.out.println("Exception was thrown: " + e);
        }
        System.out.println("---------------------------------------------------------------------\n");
    }
}
