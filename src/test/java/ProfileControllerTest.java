import fitnessTracker2.ProfileController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileControllerTest {

    @Test
    public void calcBmiTest() {
        assertEquals(29.2, ProfileController.calcBmi(185.0, 100.0));
        assertEquals(19.4, ProfileController.calcBmi(190.0, 70.0));
        assertEquals(17.8, ProfileController.calcBmi(260.0, 120.0));
    }
}