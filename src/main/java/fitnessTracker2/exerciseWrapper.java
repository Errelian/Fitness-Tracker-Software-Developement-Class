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

    public static void initialize(){

        exerciseArrayList = new ArrayList<exercise>(){
            {
                add(new exercise("Aerobic", 457));
            }
        };

        exerciseArrayList.add(new exercise("Archery", 246));
        exerciseArrayList.add(new exercise("Hiking", 493));

        exerciseArrayList.add(new exercise("Badminton", 317));
        exerciseArrayList.add(new exercise("Ballet", 317));
        exerciseArrayList.add(new exercise("Boxing", 844));

        exerciseArrayList.add(new exercise("Basketball", 422));
        exerciseArrayList.add(new exercise("Fishing", 211));
        exerciseArrayList.add(new exercise("Football", 633));

        exerciseArrayList.add(new exercise("Golf", 317));
    }

    public void append(exercise exercise){
        exerciseArrayList.add(exercise);
    }

}
