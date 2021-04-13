package fitnessTracker2;


import lombok.Data;

import java.util.ArrayList;

/**
 * A Wrapper for Exercise. The data is static.
 */
@Data
public class ExerciseWrapper {

    /**
     * Exercise ArrayList that holds every read Exercise type.
     */
    public static ArrayList<Exercise> exerciseArrayList;

    /**
     * Simple args constructor.
     * @param exercise Exercise to be added.
     */
    public ExerciseWrapper(Exercise exercise){

        exerciseArrayList = new ArrayList<Exercise>(){
            {
                add(exercise);
            }
        };

    }

    /**
     * Deprecated method for initializing default values.
     */
    @Deprecated
    public static void initialize(){

        exerciseArrayList = new ArrayList<Exercise>(){
            {
                add(new Exercise("Aerobic", 457));
            }
        };

        exerciseArrayList.add(new Exercise("Archery", 246));
        exerciseArrayList.add(new Exercise("Hiking", 493));

        exerciseArrayList.add(new Exercise("Badminton", 317));
        exerciseArrayList.add(new Exercise("Ballet", 317));
        exerciseArrayList.add(new Exercise("Boxing", 844));

        exerciseArrayList.add(new Exercise("Basketball", 422));
        exerciseArrayList.add(new Exercise("Fishing", 211));
        exerciseArrayList.add(new Exercise("Football", 633));

        exerciseArrayList.add(new Exercise("Golf", 317));
    }

    /**
     * Simple method to add an additional exercise.
     * @param exercise Exercise to be added.
     */
    public static void append(Exercise exercise){
        exerciseArrayList.add(exercise);
    }

}
