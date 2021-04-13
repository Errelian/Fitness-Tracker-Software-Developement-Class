package fitnessTracker2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Simple wrapper for profiles.
 * Uses Lombok.
 */
@Data
@AllArgsConstructor
public class ProfileWrapper {
    /**
     * The wrapped profile.
     */
    public static Profile profile;
}
