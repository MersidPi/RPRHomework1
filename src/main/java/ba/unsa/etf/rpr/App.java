package ba.unsa.etf.rpr;

/**
 * Entry point to ExpressionEvaluator class that implements Dijkstra's Algorithm for expression evaluation
 * @Author Mersid Pilipović
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("\n\n---------------------------------------------------------------------\n" +
                "Make sure that the input expression is one parameter and in form of examples:" +
                "\n\"( 6 * 3 )\",  \"( ( 6 * sqrt ( 8 ) ) - ( 5 / 6 ) )\",  \"sqrt ( 3 )\"" +
                "\n\"( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )\" "+
                "\nIf you don't follow these forms of expression, result may not be correct.");
        String unos = " sqrt ( 3  ) ";
        try {
            System.out.println("\nEvaluating expression with Dijkstra's Algorithm..." +
                    "\nResult: " + unos + " = " + ExpressionEvaluator.evaluate(unos));
        }
        catch (Exception e) {
            System.out.println("Exception was thrown: " + e);
        }
        System.out.println("---------------------------------------------------------------------\n");
    }
}
