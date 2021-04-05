package fitnessTracker2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class addFxmlController implements Initializable {

    public ChoiceBox<String> exerciseTypeChoiceBox;


    private String tempExerciseString = "";
    private exercise tempExercise;


    private boolean readExerciseChoiceBox(){

        if (exerciseTypeChoiceBox.getValue() != null)
        {
            tempExerciseString = (String) exerciseTypeChoiceBox.getValue();

            if( !(tempExerciseString.equals("")) ) {
                for (int i = 0; i < exerciseWrapper.exerciseArrayList.size(); i++) {
                    if (tempExerciseString.equals(exerciseWrapper.exerciseArrayList.get(i).getName())) {
                        tempExercise = exerciseWrapper.exerciseArrayList.get(i);

                        System.out.println(tempExercise);

                        return true;
                    }
                }
            }
        }
        return false;
    }

    @FXML
    public void saveButtonAction(){

        readExerciseChoiceBox();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    for (int i = 0; i < exerciseWrapper.exerciseArrayList.size(); i++)
    {
        exerciseTypeChoiceBox.getItems().add(exerciseWrapper.exerciseArrayList.get(i).getName()); //a choice box választásainak beállítása
    }

    }
}
