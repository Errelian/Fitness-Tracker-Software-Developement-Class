package fitnessTracker2;

import lombok.Data;

import java.util.ArrayList;

/**
 * A Wrapper for Exercise Sessions, so it can be static.
 * Lombok generated Data.
 */
@Data
public class ExerciseSessionWrapper {
    /**
     * The static Array that holds all the Exercise Sessions.
     */
    public static ArrayList<ExerciseSession> exerciseSessionArrayList;

    /**
     * Simple parameterized constructor.
     * @param exerciseSession The Session to be added.
     */

    public ExerciseSessionWrapper(ExerciseSession exerciseSession){

        exerciseSessionArrayList = new ArrayList<ExerciseSession>(){
            {
                add(exerciseSession);
            }
        };

    }

    /**
     * No Args constructor.
     */
    public ExerciseSessionWrapper() {
    }

    /**
     * Simple add method, deprecated.
     * @param exerciseSession the Exercise Session to be added.
     */
    public static void append(ExerciseSession exerciseSession){

        exerciseSessionArrayList.add(exerciseSession);

    }
}
