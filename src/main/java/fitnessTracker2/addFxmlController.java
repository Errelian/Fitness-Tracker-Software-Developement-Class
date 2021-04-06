package fitnessTracker2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class addFxmlController implements Initializable {

    @FXML
    public ChoiceBox<String> exerciseTypeChoiceBox;

    @FXML
    public TextField exerciseSessionNameField;
    @FXML
    public TextField exerciseDurationNameField;

    @FXML
    public DatePicker datePicker;



    private String tempString = "";

    private Double tempCalories;
    private Duration tempDuration;
    private exercise tempExercise;
    private Integer tempCode;
    private String tempName;
    private LocalDate tempDate;

    private boolean readDuration(){
        tempString = "";
        tempString = exerciseDurationNameField.getText();

        if(tempString != null && !(tempString.equals("")) && inputChecker.onlyFloat(tempString))
        {
             double tempDouble = Double.parseDouble(tempString);
             if (tempDouble < 73.0)
             {
                 Long tempLong = Math.round(3600 * tempDouble);

                 //System.out.println(tempLong);

                 tempDuration = Duration.ofSeconds(tempLong);
                 System.out.println(tempDuration);

                 return true;
             }
             else
             {
                return false;
             }

        }
        else
        {
            return false;
        }
    }

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
        tempString = "";
        if (exerciseTypeChoiceBox.getValue() != null)
        {
            tempString = (String) exerciseTypeChoiceBox.getValue();

            if( !(tempString.equals("")) ) {
                for (int i = 0; i < exerciseWrapper.exerciseArrayList.size(); i++) {
                    if (tempString.equals(exerciseWrapper.exerciseArrayList.get(i).getName())) {
                        tempExercise = exerciseWrapper.exerciseArrayList.get(i);

                        //System.out.println(tempExercise);

                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean readIntesityChoiceBox(){
        return true;
    }

    private boolean setCalories(){
        return true;
    }

    @FXML
    public void saveButtonAction(){

        readExerciseChoiceBox();

        setCode();

        readName();

        readDate();

        readDuration();
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
