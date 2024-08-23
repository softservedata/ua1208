package test.java.com.softserve.homework.hw08;

import main.java.com.softserve.homework.hw08.CollectionsOfNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CollectionOfNumbersTest {
    private CollectionsOfNumbers collectionsOfNumbers;
    private List<Integer> testNumbers;

    @BeforeEach
    public void setUp() {
        collectionsOfNumbers = new CollectionsOfNumbers();
        testNumbers = Arrays.asList(10, 23, 33, 44, 55, 66, 78, 89);
    }

    @ParameterizedTest
    @DisplayName("Positive Test for Minimum Value in Collection")
    @MethodSource("positiveMinProvider")
    public void testFindMinPositive(List<Integer> numbers, int expectMin) {
        assertEquals(expectMin, collectionsOfNumbers.findMin(numbers));
    }

    static Stream<Arguments> positiveMinProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(10, 23, 33), 10),
                Arguments.of(Arrays.asList(4, 5, 6), 4)
        );
    }

    @ParameterizedTest
    @DisplayName("Negative Test for Minimum Value in Collection")
    @MethodSource("negativeMinProvider")
    public void testFindMinNegative(List<Integer> numbers, Integer expectMin) {
        if (numbers == null || numbers.isEmpty()) {
            assertThrows(NoSuchElementException.class, () -> collectionsOfNumbers.findMin(numbers));
        } else {
            assertNotEquals(expectMin, collectionsOfNumbers.findMin(numbers));
        }
    }

    static Stream<Arguments> negativeMinProvider() {
        return Stream.of(
                Arguments.of(List.of(), null),  // Empty list
                Arguments.of(null, null),       // Null list
                Arguments.of(Arrays.asList(10, 23, 33), 50)  // Incorrect expected value
        );
    }

    @ParameterizedTest
    @DisplayName("Positive Test for Maximum Value in Collection")
    @MethodSource("positiveMaxProvider")
    public void testFindMax(List<Integer> numbers, int expectMax) {
        assertEquals(expectMax, collectionsOfNumbers.findMax(numbers));
    }

    static Stream<Arguments> positiveMaxProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(10, 23, 33), 33),
                Arguments.of(Arrays.asList(4, 5, 6), 6)
        );
    }

    @ParameterizedTest
    @DisplayName("Negative Test for Maximum Value in Collection")
    @MethodSource("negativeMinProvider")
    public void testFindMaxNegative(List<Integer> numbers, Integer expectMax) {
        if (numbers == null || numbers.isEmpty()) {
            assertThrows(NoSuchElementException.class, () -> collectionsOfNumbers.findMin(numbers));
        } else {
            assertNotEquals(expectMax, collectionsOfNumbers.findMax(numbers));
        }
    }

    static Stream<Arguments> negativeMaxProvider() {
        return Stream.of(
                Arguments.of(List.of(), null),
                Arguments.of(null, null),
                Arguments.of(Arrays.asList(10, 23, 33), 50)
        );
    }

    @ParameterizedTest
    @DisplayName("Test for Average Calculation")
    @MethodSource("avgProvider")
    public void averageCalculation(List<Integer> numbers, double expectedAverage) {
        assertEquals(expectedAverage, collectionsOfNumbers.calculateAverage(numbers));
    }

    static Stream<Arguments> avgProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(10, 20, 30), 20.0),
                Arguments.of(Arrays.asList(10, 23, 33, 44), 27.5)
        );
    }

    @ParameterizedTest
    @DisplayName("Test for Removing Even Numbers")
    @MethodSource("evenRemovalProvider")
    public void testRemoveEvenNumbers(List<Integer> numbers, List<Integer> expectedNumbers) {
        List<Integer> modifiableNumbers = new ArrayList<>(numbers);
        assertEquals(expectedNumbers, collectionsOfNumbers.removeEvenNumbers(modifiableNumbers));
    }

    static Stream<Arguments> evenRemovalProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(10, 23, 33, 44), Arrays.asList(23, 33)),
                Arguments.of(Arrays.asList(22, 42, 63, 71), Arrays.asList(63, 71))
        );
    }

    @ParameterizedTest
    @DisplayName("Test for Containing Number")
    @CsvSource({
            "33, true",
            "100, false"
    })
    public void testContainsNumber(int numberToCheck, boolean expectedResult) {
        assertEquals(expectedResult, collectionsOfNumbers.containsNumber(testNumbers, numberToCheck));
    }

    @ParameterizedTest
    @DisplayName("Test for Sorting Numbers")
    @MethodSource("sortProvider")
    public void testSortNumbers(List<Integer> numbers, List<Integer> expectedSortedNumbers) {
        assertEquals(expectedSortedNumbers, collectionsOfNumbers.sortNumbers(numbers));
    }

    static Stream<Arguments> sortProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(10, 44, 23, 33), Arrays.asList(10, 23, 33, 44)),
                Arguments.of(Arrays.asList(50, 40, 60), Arrays.asList(40, 50, 60))
        );
    }
}

