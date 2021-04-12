package fitnessTracker2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputCheckerTest {

    @Test
    void onlyInteger() {
        assertTrue(InputChecker.onlyInteger("12"));
        assertTrue(InputChecker.onlyInteger("3333"));
        assertTrue(InputChecker.onlyInteger("0"));

        assertFalse(InputChecker.onlyInteger("asd"));
        assertFalse(InputChecker.onlyInteger("12.3"));
        assertFalse(InputChecker.onlyInteger(".23"));
    }

    @Test
    void onlyFloat() {

        assertTrue(InputChecker.onlyFloat("12.3"));
        assertTrue(InputChecker.onlyFloat("23"));
        assertTrue(InputChecker.onlyFloat(".3"));

        assertFalse(InputChecker.onlyFloat("asd"));
        assertFalse(InputChecker.onlyFloat("12,7"));
    }
}