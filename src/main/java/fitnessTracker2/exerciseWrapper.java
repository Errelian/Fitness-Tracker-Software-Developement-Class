package fitnessTracker2;


import java.util.ArrayList;

@lombok.Data
public class exerciseWrapper {

    public static ArrayList<exercise> exerciseArrayList;


    public exerciseWrapper(exercise exercise){

        exerciseArrayList = new ArrayList<exercise>(){
            {
                add(exercise);
            }
        };

    }

    public void append(exercise exercise){
        exerciseArrayList.add(exercise);
    }

}
