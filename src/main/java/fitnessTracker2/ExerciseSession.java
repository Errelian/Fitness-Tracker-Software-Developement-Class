package fitnessTracker2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

/**
 * Simple class to hold all needed information about an Exercise Session.
 * Getters/Setters and Constructors generated with Lombok.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseSession {

    private Integer code;
    private String name;
    private LocalDate startDate;
    private Duration exerciseDuration;
    private Exercise exerciseType; //beolvassa az alap jsonból az alapértelmezett sportokat és costokaat, aztán megnézi a custom jsonról
    private Double burnedCalories;
    private double intensity;

}
