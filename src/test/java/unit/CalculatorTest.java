package unit;

import calculator.Calculator;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * CalculatorTest includes tests for calculator.Calculator class.
 *
 * @author alexpshe
 * @version 1.0
 */
public class CalculatorTest {
    private Calculator calculator;
    private SoftAssertions softly;

    // метод, выполняемый перед всеми тестами
    @BeforeAll
    public static void setupBeforeAllTest() {
    }

    // метод, выполняемый перед каждым тестом
    @BeforeEach
    public void setup() {
        this.calculator = new Calculator();
        this.softly = new SoftAssertions();
    }

    @AfterEach
    public void assertAll() {
        this.softly.assertAll();
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    public void repeatedTest() {
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, -10 })
    public void parameterizedWithValuesTest() {
    }

    @DisplayName("Base positive test for sum")
    @Tag("calculator")
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3", // тест кейс 1
            "-10, -20, -30" // тест кейс 2
    })
    public void sumTest(int firstValue, int secondValue, int expectedResult) {
        int actualResult = calculator.sum(firstValue, secondValue);

        softly.assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Tag("calculator")
    @Test
    @DisplayName("Base positive test for multiple")
    public void multipleTest(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        long actualResult = calculator.multiple(numbers);
        int expectedResult = 240;
        softly.assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("Base positive test for divide")
    @Tag("calculator")
    @ParameterizedTest
    @CsvSource({
            "6, 2, 3", // тест кейс 1
            "5, 3, 5" // тест кейс 2
    })
    public void divide(int dividend, int divisor, int expectedResult){
        double actualResult = calculator.divide(dividend, divisor);

        softly.assertThat(actualResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv")
    public void divideTest(int firstValue, int secondValue, int expectedResult) {
        double actualResult = calculator.divide(firstValue, secondValue);

        softly.assertThat(actualResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> testDataForSumOfCollectionValues() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 3, 4), 8), // тест кейс 1
                Arguments.of(Arrays.asList(-1, 0, 1), 0) // тест кейс 2
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("testDataForSumOfCollectionValues")
    public void sumOfCollectionValuesTest(List<Integer> numbers, long expectedResult) {
        long actualResult = calculator.sum(numbers);

        softly.assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @Disabled
    @Tag("broken")
    public void brokenTest() {
    }
}
