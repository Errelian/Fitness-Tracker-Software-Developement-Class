package fitnessTracker2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Simple class for holding all information needed for a profile in one place.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private String name;
    private Double weight;

    private Double height;
    private Double bmi;

}
