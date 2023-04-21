package com.example.regionkommunev1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Test1 {

    @Test
    void testArr() {
        int[] numbers = {1,2,3,8,4};
        int[] expected = {1,2,3,4,8};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    void testArrMsg() {
        int[] numbers = {1,2,3,8,4};
        int[] expected = {1,2,31,4,8};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, "Tester 5 tal" + numbers[1]);
    }

    @Test
    void testArrNot() {
        int[] numbers = {1,2,3,8,4};
        int[] expected = {1,2,31,4,8};
        Arrays.sort(numbers);
        assertNotEquals(numbers[0], expected[3]);
    }

    @DisplayName("Test dog den sort")
    @ParameterizedTest
    @MethodSource("sortednumbersArguments")
    void testArrParm(int[] numbers, int[] expected) {
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers, "Sortering af " + numbers.length + " tal");
    }

    private static Stream<Arguments> sortednumbersArguments() {
        return Stream.of(
                Arguments.of(IntStream.of(1,2,3).toArray(), IntStream.of(1,2,3).toArray()),
                Arguments.of(IntStream.of(8,1,2,13,5).toArray(), IntStream.of(1,2,3,5,8).toArray()),
                Arguments.of(IntStream.of(16,1,2,3).toArray(), IntStream.of(1,2,3,16).toArray())
        );
    }


}
