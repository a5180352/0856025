package lovepoem.test2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

class PriorityQueueTest {
    private static Random rand;

    @BeforeAll
    static void tearUp() {
        rand = new Random();
    }

    static Stream<ArrayList<Integer>> elementGenerator() {
        ArrayList<ArrayList<Integer>> testCases = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            temp.clear();
            for (int j = 0; j < 10; j++) {
                temp.add(rand.nextInt() % 1000);
            }
            testCases.add(new ArrayList<>(temp));
        }
        return testCases.stream();
    }

    @ParameterizedTest
    @MethodSource("elementGenerator")
    void pQueueTest(ArrayList<Integer> elements) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (Integer e : elements) {
            pQueue.add(e);
        }
        Collections.sort(elements);
        for (Integer e : elements) {
            assertEquals(e, pQueue.poll());
        }
    }

    @Test
    void exception_1() {
        assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> pQueue = new PriorityQueue<>();
            pQueue.add(null);
        });
    }

    @Test
    void exception_2() {
        assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> pQueue = null;
            pQueue.toArray();
        });
    }

    @Test
    void exception_3() {
        assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue<Integer> pQueue = new PriorityQueue<>(0);
        });
    }
}