package fitnessTracker2;

/**
 * Simple class for holding all information needed for a profile in one place.
 */
public class Profile {
    private String name;
    private Double weight;

    private Double height;
    private Double bmi;

    /**
     * Constructor.
     * @param name Name of the profile.
     * @param weight Weight of the person.
     * @param height Height of the person.
     * @param bmi Bmi of the person.
     */
    public Profile(String name, Double weight, Double height, Double bmi) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }

    /**
     * Default constructor.
     */
    public Profile() {
    }

    /**
     * Getter.
     * @return String, name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter.
     * @return Weight
     */
    public Double getWeight() {
        return this.weight;
    }

    /**
     * Getter.
     * @return Height
     */
    public Double getHeight() {
        return this.height;
    }

    /**
     * Getter.
     * @return BMI
     */
    public Double getBmi() {
        return this.bmi;
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
     * @param weight
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * Setter.
     * @param height
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * Setter.
     * @param bmi
     */
    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    /**
     * Equals method.
     * @param o
     * @return Boolean, equals or not
     */
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Profile)) return false;
        final Profile other = (Profile) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$weight = this.getWeight();
        final Object other$weight = other.getWeight();
        if (this$weight == null ? other$weight != null : !this$weight.equals(other$weight)) return false;
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        if (this$height == null ? other$height != null : !this$height.equals(other$height)) return false;
        final Object this$bmi = this.getBmi();
        final Object other$bmi = other.getBmi();
        if (this$bmi == null ? other$bmi != null : !this$bmi.equals(other$bmi)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Profile;
    }

    /**
     * Hashcode method.
     * @return INT, hashcode
     */
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $weight = this.getWeight();
        result = result * PRIME + ($weight == null ? 43 : $weight.hashCode());
        final Object $height = this.getHeight();
        result = result * PRIME + ($height == null ? 43 : $height.hashCode());
        final Object $bmi = this.getBmi();
        result = result * PRIME + ($bmi == null ? 43 : $bmi.hashCode());
        return result;
    }

    /**
     * ToString method.
     * @return String.
     */
    public String toString() {
        return "Profile(name=" + this.getName() + ", weight=" + this.getWeight() + ", height=" + this.getHeight() + ", bmi=" + this.getBmi() + ")";
    }
}
