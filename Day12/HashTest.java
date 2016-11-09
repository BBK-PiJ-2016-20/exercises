import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;

public class HashTest {

    public void testHashN(int n) {
        int hash = HashUtilities.shortHash(n);
        assertTrue("For " + n + ": 0 < " + hash + " < 1000", 0 < hash && hash < 1000);
    }

    @Test
    public void testHash0() {
        testHashN(0);
    }

    @Test
    public void testHash1() {
        testHashN(1);
    }

    @Test
    public void testHash500() {
        testHashN(500);
    }

    @Test
    public void testHash999() {
        testHashN(999);        
    }

    @Test
    public void testHash1000() {
        testHashN(1000);
    }

    @Test
    public void testHash10000() {
        testHashN(10000);
    }

    @Test
    public void testHashNegative1() {
        testHashN(-1);
    }

    @Test
    public void testHashNegative500() {
        testHashN(-500);
    }

    @Test
    public void testHashNegative999() {
        testHashN(-999);
    }

    @Test
    public void testHashNegative1000() {
        testHashN(-1000);
    }

    @Test
    public void testHashNegative10000() {
        testHashN(-10000);
    }

    @Test
    public void testRandomHashes() {
        Random r = new Random();
        for (int i = 0; i < 2000; i++) {
            testHashN(r.nextInt());
        }
    }
}