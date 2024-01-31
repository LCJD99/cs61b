package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    @Test
    public void MaxValueTest() {
        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>(Comparator.naturalOrder());
        for (int i = 0; i < 100; i++) {
            lld1.addLast(i);
        }
        assertEquals("should have same value", 99, (double) lld1.max(), 0.0);
    }
}
