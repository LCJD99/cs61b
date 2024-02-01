package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> al1 = new AListNoResizing<>();
        BuggyAList<Integer> al2 = new BuggyAList<>();
        al1.addLast(1);
        al1.addLast(2);
        al1.addLast(3);
        al2.addLast(1);
        al2.addLast(2);
        al2.addLast(3);
        assertEquals(al1.removeLast(), al2.removeLast());
        assertEquals(al1.removeLast(), al2.removeLast());
        assertEquals(al1.removeLast(), al2.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size1 = L.size();
                int size2 = B.size();
                assertEquals(size1, size2);
            } else if (operationNumber == 2 && L.size() > 0) {
                // getLast
                int last1 = L.getLast();
                int last2 = B.getLast();
                assertEquals(last1 , last2);
            } else if (operationNumber == 3 && L.size() > 0) {
                // removeLast
                int last1 = L.removeLast();
                int last2 = B.removeLast();
                assertEquals(last1 , last2);
            }
        }
    }
}
