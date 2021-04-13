package fitnessTracker2;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Simple class to hold all needed information about an exercise type.
 * Getters/Setters and Constructors generated with Lombok.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    private String name;
    private Integer calorieCost;        //70 kilóra- abbó meg scalelünk user profile alapján

}
