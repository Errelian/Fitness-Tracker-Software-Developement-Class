package fitnessTracker2;


/**
 * Simple class to hold all needed information about an exercise type.
 * Getters/Setters and Constructors generated with Lombok.
 */
public class Exercise {

    private String name;
    private Integer calorieCost;        //70 kilóra- abbó meg scalelünk user profile alapján

    /**
     * Contructor.
     * @param name Name of the exercise
     * @param calorieCost KCalorie cost.
     */
    public Exercise(String name, Integer calorieCost) {
        this.name = name;
        this.calorieCost = calorieCost;
    }

    /**
     * No args Ctor.
     */
    public Exercise() {
    }

    /**
     * Getter.
     * @return Name field.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter.
     * @return Calorie field.
     */
    public Integer getCalorieCost() {
        return this.calorieCost;
    }

    /**
     * Setter.
     * @param name Name value.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter.
     * @param calorieCost Calorie cost value.
     */
    public void setCalorieCost(Integer calorieCost) {
        this.calorieCost = calorieCost;
    }

    /**
     * Equals method.
     * @param o object to compare to
     * @return Boolean, equal or not
     */
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Exercise)) return false;
        final Exercise other = (Exercise) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$calorieCost = this.getCalorieCost();
        final Object other$calorieCost = other.getCalorieCost();
        if (this$calorieCost == null ? other$calorieCost != null : !this$calorieCost.equals(other$calorieCost))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Exercise;
    }

    /**
     * Creates a hash.
     * @return a Hash.
     */
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $calorieCost = this.getCalorieCost();
        result = result * PRIME + ($calorieCost == null ? 43 : $calorieCost.hashCode());
        return result;
    }

    /**
     * ToString().
     * @return String version.
     */
    public String toString() {
        return "Exercise(name=" + this.getName() + ", calorieCost=" + this.getCalorieCost() + ")";
    }
}
