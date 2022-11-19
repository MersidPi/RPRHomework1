package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class that tests various inputs for evaluation of expressions in ExpressionEvaluator
 * @Author Mersid Pilipović
 */
class ExpressionEvaluatorTest {

    /**
     * Test for valid input ( 6 * 3 ), which should be 18
     */
    @Test
    void evaluate1() {
        assertEquals(18, ExpressionEvaluator.evaluate("( 6 * 3 )"));
    }

    /**
     * Test for invalid input if operator isn't separated with space
     */
    @Test
    void evaluate2() {
        assertThrows(RuntimeException.class, () -> {
                double result = ExpressionEvaluator.evaluate("( 6* 3 )");
            }, "Invalid expression");
    }

    /**
     * Test for invalid input if nothing is separated with space
     */
    @Test
    void evaluate3() {
        assertThrows(RuntimeException.class, () -> {
            double result = ExpressionEvaluator.evaluate("(6*3)");
        }, "Invalid expression");
    }

    /**
     * Test for valid input ( ( 6 * sqrt ( 16 ) ) - ( 5 / 4 ) ) which should be 22.75
     */
    @Test
    void evaluate4() {
        assertEquals(22.75, ExpressionEvaluator.evaluate("( ( 6 * sqrt ( 16 ) ) - ( 5 / 4 ) )"));
    }

    /**
     * Test for valid input ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) which should be 101
     */
    @Test
    void evaluate5() {
        assertEquals(101, ExpressionEvaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
    }

    /**
     * Test for invalid input that isn't expression
     */
    @Test
    void evaluate6() {
        assertThrows(RuntimeException.class, () -> {
            double result = ExpressionEvaluator.evaluate("lol");
        }, "Invalid expression");
    }
    /**
     * Test for sqrt
     */
    @Test
    void evaluate7() {
        assertEquals(8, ExpressionEvaluator.evaluate("sqrt ( ( 70 - 6 ) )"));
    }
}