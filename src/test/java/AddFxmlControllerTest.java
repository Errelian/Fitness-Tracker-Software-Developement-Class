import fitnessTracker2.AddFxmlController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddFxmlControllerTest {

    @Test
    public void calcCalorieTest() {
        assertEquals(652.9, AddFxmlController.calcCalorie(80.0, 457.0, 1.25));
        assertEquals(672.4, AddFxmlController.calcCalorie(90.0, 523.0, 1.00));
        assertEquals(464.8, AddFxmlController.calcCalorie(60.0, 723.0, 0.75));
    }
}