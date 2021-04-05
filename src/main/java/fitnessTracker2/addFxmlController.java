package fitnessTracker2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class addFxmlController implements Initializable {

    public ChoiceBox<String> exerciseTypeChoiceBox;
    public TextField exerciseSessionNameField;
    public DatePicker datePicker;

    private String tempExerciseString = "";


    private exercise tempExercise;
    private Integer tempCode;
    private String tempName;
    private LocalDate tempDate;

    private boolean readDate(){

        tempDate = datePicker.getValue();

        if (tempDate != null)
        {
            //System.out.println(tempDate);
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean readName(){
        tempName = exerciseSessionNameField.getText(); //bármilyen sztringet elfogad, nem látom értelméd a számok kiszűrésének

        //System.out.println(tempName);

        return true;
    }

    private boolean setCode() {
        tempCode =  exerciseSessionWrapper.exerciseSessionArrayList.get(exerciseSessionWrapper.exerciseSessionArrayList.size() - 1).getCode() + 1;

        //System.out.println(tempCode);

        return true;
    }

    private boolean readExerciseChoiceBox(){

        if (exerciseTypeChoiceBox.getValue() != null)
        {
            tempExerciseString = (String) exerciseTypeChoiceBox.getValue();

            if( !(tempExerciseString.equals("")) ) {
                for (int i = 0; i < exerciseWrapper.exerciseArrayList.size(); i++) {
                    if (tempExerciseString.equals(exerciseWrapper.exerciseArrayList.get(i).getName())) {
                        tempExercise = exerciseWrapper.exerciseArrayList.get(i);

                        //System.out.println(tempExercise);

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

        setCode();

        readName();

        readDate();
        //TODO
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    for (int i = 0; i < exerciseWrapper.exerciseArrayList.size(); i++)
    {
        exerciseTypeChoiceBox.getItems().add(exerciseWrapper.exerciseArrayList.get(i).getName()); //a choice box választásainak beállítása
    }

    }
}
