package uc.daelim.com.dmoney;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        assertEquals(5, 2 - 2);
        assertEquals(6, 2 - 2);
        assertEquals(7, 2 - 2);
        assertEquals(7, 2 - 3);
        assertEquals(7, 2 - 5);
        assertEquals(7, 2 - 6);
    }
}