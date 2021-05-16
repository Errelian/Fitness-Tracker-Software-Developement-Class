package fitnessTracker2;

import java.time.Duration;
import java.time.LocalDate;

/**
 * Simple class to hold all needed information about an Exercise Session.
 * Getters/Setters and Constructors generated with Lombok.
 */
public class ExerciseSession {

    private Integer code;
    private String name;
    private LocalDate startDate;
    private Duration exerciseDuration;
    private Exercise exerciseType; //beolvassa az alap jsonból az alapértelmezett sportokat és costokaat, aztán megnézi a custom jsonról
    private Double burnedCalories;
    private double intensity;

    /**
     * @param code Identifying code.
     * @param name Simple string.
     * @param startDate JSR 310 compliant LocalDate object
     * @param exerciseDuration JSR 310 compliant Duration object
     * @param exerciseType Object to determine the exercise's type
     * @param burnedCalories Total burned calories
     * @param intensity Intensity of the exercise
     */
    public ExerciseSession(Integer code, String name, LocalDate startDate, Duration exerciseDuration, Exercise exerciseType, Double burnedCalories, double intensity) {
        this.code = code;
        this.name = name;
        this.startDate = startDate;
        this.exerciseDuration = exerciseDuration;
        this.exerciseType = exerciseType;
        this.burnedCalories = burnedCalories;
        this.intensity = intensity;
    }

    /**
     * Default Ctor.
     */
    public ExerciseSession() {
    }

    /**
     * Getter.
     * @return Code
     */
    public Integer getCode() {
        return this.code;
    }
    /**
     * Getter.
     * @return Name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Getter.
     * @return startDate
     */
    public LocalDate getStartDate() {
        return this.startDate;
    }
    /**
     * Getter.
     * @return Duration
     */
    public Duration getExerciseDuration() {
        return this.exerciseDuration;
    }
    /**
     * Getter.
     * @return Exercise
     */
    public Exercise getExerciseType() {
        return this.exerciseType;
    }
    /**
     * Getter.
     * @return Double
     */
    public Double getBurnedCalories() {
        return this.burnedCalories;
    }
    /**
     * Getter.
     * @return Double
     */
    public double getIntensity() {
        return this.intensity;
    }

    /**
     * Setter.
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Setter.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter.
     * @param startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Setter.
     * @param exerciseDuration
     */
    public void setExerciseDuration(Duration exerciseDuration) {
        this.exerciseDuration = exerciseDuration;
    }

    /**
     * Setter.
     * @param exerciseType
     */
    public void setExerciseType(Exercise exerciseType) {
        this.exerciseType = exerciseType;
    }

    /**
     * Setter.
     * @param burnedCalories
     */
    public void setBurnedCalories(Double burnedCalories) {
        this.burnedCalories = burnedCalories;
    }

    /**
     * Setter.
     * @param intensity
     */
    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    /**
     * Equals method.
     * @param o
     * @return Boolean, equals or not.
     */
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ExerciseSession)) return false;
        final ExerciseSession other = (ExerciseSession) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$code = this.getCode();
        final Object other$code = other.getCode();
        if (this$code == null ? other$code != null : !this$code.equals(other$code)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$startDate = this.getStartDate();
        final Object other$startDate = other.getStartDate();
        if (this$startDate == null ? other$startDate != null : !this$startDate.equals(other$startDate)) return false;
        final Object this$exerciseDuration = this.getExerciseDuration();
        final Object other$exerciseDuration = other.getExerciseDuration();
        if (this$exerciseDuration == null ? other$exerciseDuration != null : !this$exerciseDuration.equals(other$exerciseDuration))
            return false;
        final Object this$exerciseType = this.getExerciseType();
        final Object other$exerciseType = other.getExerciseType();
        if (this$exerciseType == null ? other$exerciseType != null : !this$exerciseType.equals(other$exerciseType))
            return false;
        final Object this$burnedCalories = this.getBurnedCalories();
        final Object other$burnedCalories = other.getBurnedCalories();
        if (this$burnedCalories == null ? other$burnedCalories != null : !this$burnedCalories.equals(other$burnedCalories))
            return false;
        if (Double.compare(this.getIntensity(), other.getIntensity()) != 0) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ExerciseSession;
    }

    /**
     * HashCode method.
     * @return hashcode
     */
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $code = this.getCode();
        result = result * PRIME + ($code == null ? 43 : $code.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $startDate = this.getStartDate();
        result = result * PRIME + ($startDate == null ? 43 : $startDate.hashCode());
        final Object $exerciseDuration = this.getExerciseDuration();
        result = result * PRIME + ($exerciseDuration == null ? 43 : $exerciseDuration.hashCode());
        final Object $exerciseType = this.getExerciseType();
        result = result * PRIME + ($exerciseType == null ? 43 : $exerciseType.hashCode());
        final Object $burnedCalories = this.getBurnedCalories();
        result = result * PRIME + ($burnedCalories == null ? 43 : $burnedCalories.hashCode());
        final long $intensity = Double.doubleToLongBits(this.getIntensity());
        result = result * PRIME + (int) ($intensity >>> 32 ^ $intensity);
        return result;
    }

    /**
     * toString method.
     * @return String.
     */
    public String toString() {
        return "ExerciseSession(code=" + this.getCode() + ", name=" + this.getName() + ", startDate=" + this.getStartDate() + ", exerciseDuration=" + this.getExerciseDuration() + ", exerciseType=" + this.getExerciseType() + ", burnedCalories=" + this.getBurnedCalories() + ", intensity=" + this.getIntensity() + ")";
    }
}
