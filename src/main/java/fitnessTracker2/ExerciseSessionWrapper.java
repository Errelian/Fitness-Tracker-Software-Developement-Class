package fitnessTracker2;

import java.util.ArrayList;

@lombok.Data
public class ExerciseSessionWrapper {
    public static ArrayList<ExerciseSession> exerciseSessionArrayList;

    public ExerciseSessionWrapper(ExerciseSession exerciseSession){

        exerciseSessionArrayList = new ArrayList<ExerciseSession>(){
            {
                add(exerciseSession);
            }
        };

    }

    public ExerciseSessionWrapper() {
    }

    public static void append(ExerciseSession exerciseSession){

        exerciseSessionArrayList.add(exerciseSession);

    }
}
