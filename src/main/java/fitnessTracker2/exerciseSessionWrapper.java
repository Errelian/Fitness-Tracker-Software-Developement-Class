package fitnessTracker2;

import java.util.ArrayList;

@lombok.Data
public class exerciseSessionWrapper {
    public static ArrayList<exerciseSession> exerciseSessionArrayList;

    public exerciseSessionWrapper(exerciseSession exerciseSession){

        exerciseSessionArrayList = new ArrayList<exerciseSession>(){
            {
                add(exerciseSession);
            }
        };

    }

    public exerciseSessionWrapper() {
    }

    public static void append(exerciseSession exerciseSession){

        exerciseSessionArrayList.add(exerciseSession);

    }
}
