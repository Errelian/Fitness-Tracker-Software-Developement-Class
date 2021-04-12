package fitnessTracker2;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Profile {
    private String name;
    private Double weight;

    private Double height;
    private Double bmi;

}
