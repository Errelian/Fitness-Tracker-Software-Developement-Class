package fitnessTracker2;

import java.time.Duration;
import java.time.LocalDate;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class ExerciseSession {

    private Integer code;
    private String name;
    private LocalDate startDate;
    private Duration exerciseDuration;
    private Exercise exerciseType; //beolvassa az alap jsonból az alapértelmezett sportokat és costokaat, aztán megnézi a custom jsonról
    private Double burnedCalories;
    private double intensity;

}
