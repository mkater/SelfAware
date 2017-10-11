import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthew.kater on 10/11/2017.
 */
public class SelfAwareTest {
    @Before

    @Test
    public void occurrences() throws Exception {
        String s = "Java has many keywords like short and return";
        int occ = new SelfAware().occurrences(s);
        assertEquals(2, occ);
    }

}