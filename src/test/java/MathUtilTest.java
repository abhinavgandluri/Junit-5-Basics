
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MathUtilTest {

    private MathUtils mathUtils;

     TestInfo testInfo;

      TestReporter testReporter;

     boolean isServerUp = false;

    @BeforeEach
     void setUp(TestInfo testInfo, TestReporter testReporter) {
        mathUtils = new MathUtils();
        this.testInfo = testInfo;
        this.testReporter = testReporter;

    }

    @AfterAll
     void cleanUp() {
        System.out.println("Cleaninig up...!!!");
    }


    @Test
    @DisplayName("Test two numbers")
    @Tag("Add")
    @RepeatedTest(2)
    void testAdd(RepetitionInfo repetitionInfo) {

        System.out.println(testInfo.getTestMethod());
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Test Multiply")
    void testMultiply(){
        assertAll(
                () -> assertEquals(0, mathUtils.multiply(1, 0)),
                () -> assertEquals(1, mathUtils.multiply(1, 1)),
                () -> assertEquals(5, mathUtils.multiply(2, 3))
        );
    }

    @Test
    @Disabled
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),
                "Divide should throw ArithmeticException when denominator is zero");
    }

    @Nested
    @DisplayName("Testing Nested Add Methods")
    class AddTest {
        @Test
        void testAddingTwoPositives() {
            assertEquals(2, mathUtils.add(1, 2),
                    () -> "Add method should return the sum of two numbers");
        }

        @Test
        void testAddingTwoNegatives() {
            assertEquals(-2, mathUtils.add(-1, -1),
                    "Add method should return the sum of two numbers");
        }

        @Test
        void testAddingAPositiveAndANegative() {
            assertEquals(0, mathUtils.add(-1, 1),
                    () -> "Add method should return the sum of two numbers");
        }
    }

}
