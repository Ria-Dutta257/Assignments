package com.assignment.tests;

import com.assignment.utils.NumberUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class NumberUtilsTest {

    NumberUtils utils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 50})
    void testIsPositive(int number) {

        assertTrue(utils.isPositive(number));

    }
    
    @ParameterizedTest
    @CsvSource({
            "2,4",
            "3,9",
            "4,16",
            "5,25"
    })
    void testSquare(int input, int expected) {

        assertEquals(expected, utils.square(input));

    }
    
    @ParameterizedTest
    @MethodSource("provideNumbers")
    void testSquareWithMethodSource(int input, int expected) {

        assertEquals(expected, utils.square(input));

    }
    
    static Stream<Object[]> provideNumbers() {

        return Stream.of(
                new Object[]{6,36},
                new Object[]{7,49},
                new Object[]{8,64}
        );

    }
}