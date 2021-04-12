package fitnessTracker2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class AddFxmlController implements Initializable {

    @FXML
    public ChoiceBox<String> exerciseTypeChoiceBox;
    @FXML
    public ChoiceBox<String> intensityChoiceBox;

    @FXML
    public TextField exerciseSessionNameField;
    @FXML
    public TextField exerciseDurationNameField;

    @FXML
    public DatePicker datePicker;



    private String tempString = "";

    private Double tempCalories;
    private Duration tempDuration;
    private Exercise tempExercise;
    private Integer tempCode;
    private String tempName;
    private LocalDate tempDate;
    private Double tempIntensity;

    private Map intensityMap = new HashMap();
    private void initializeMap(){
        intensityMap.put("Low Intesity", 0.75);
        intensityMap.put("Normal Intesity", 1.0);
        intensityMap.put("High Intesity", 1.25);
    }


    private boolean readDuration(){
        tempString = "";
        tempString = exerciseDurationNameField.getText();

        if(tempString != null && !(tempString.equals("")) && InputChecker.onlyFloat(tempString))
        {
             double tempDouble = Double.parseDouble(tempString);
             if (tempDouble < 73.0)
             {
                 Long tempLong = Math.round(3600 * tempDouble);

                 //System.out.println(tempLong);

                 tempDuration = Duration.ofSeconds(tempLong);
                 //System.out.println(tempDuration);

                 Logger.info("Duration successfully read");
                 return true;
             }
             else
             {
                 Logger.warn("Duration reading unsuccessful!");
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
            Logger.info("Date successfully read!");
            return true;
        }
        else
        {
            Logger.warn("Date reading unsuccessful!");
            return false;
        }
    }

    private boolean readName(){
        tempName = exerciseSessionNameField.getText(); //bármilyen sztringet elfogad, nem látom értelméd a számok kiszűrésének

        Logger.info("Name, successfully read!");

        return true;
    }

    private boolean setCode() {
        tempCode =  ExerciseSessionWrapper.exerciseSessionArrayList.get(ExerciseSessionWrapper.exerciseSessionArrayList.size() - 1).getCode() + 1;

        Logger.info("Code successfully set!");

        return true;
    }

    private boolean readExerciseChoiceBox(){
        tempString = "";
        if (exerciseTypeChoiceBox.getValue() != null)
        {
            tempString = exerciseTypeChoiceBox.getValue();

            if( !(tempString.equals("")) ) {
                for (int i = 0; i < ExerciseWrapper.exerciseArrayList.size(); i++) {
                    if (tempString.equals(ExerciseWrapper.exerciseArrayList.get(i).getName())) {
                        tempExercise = ExerciseWrapper.exerciseArrayList.get(i);

                        Logger.info("Exercise type successfully read!");

                        return true;
                    }
                }
            }
        }
        Logger.warn("Exercise type reading unsuccessful!");
        return false;
    }

    private boolean readIntensityChoiceBox(){
        tempString = "";
        if (intensityChoiceBox.getValue() != null)
        {
            tempString = intensityChoiceBox.getValue();

            if( !(tempString.equals("")) ) {
                tempIntensity = (Double) intensityMap.getOrDefault(tempString, "1.00");

                Logger.info("Intensity reading successful!");
                return true;
            }
        }
            Logger.warn("Intensity reading unsuccessful!");
            return false;
    }

    private boolean setCalories(){

        if (tempExercise !=null) {

            tempCalories = (ProfileWrapper.profile.getWeight() / 70.0) * tempExercise.getCalorieCost() * tempIntensity;

            Logger.info("Calorie reading successful!");
            return true;
        }
        else {
            Logger.warn("Calorie reading unsuccessful!");
            return false;
        }
    }

    @FXML
    public void saveButtonAction(ActionEvent event) {

        if(readExerciseChoiceBox() && setCode() && readName() && readDate() && readDuration() && readIntensityChoiceBox() && setCalories())
        {
            ExerciseSession tempSession = new ExerciseSession(tempCode, tempName,tempDate,tempDuration,tempExercise, tempCalories, tempIntensity);

            ExerciseSessionWrapper.append(tempSession);
            try {

                JsonHandler.save(JsonHandlerEnum.SESSION);

                Logger.info("Successful session saving operation!");

                final Node source = (Node) event.getSource();
                final Stage stage = (Stage) source.getScene().getWindow(); //fogalmam sincs hogy miért csak így jó

                stage.close();
            }
            catch(Exception e)
            {
                Logger.warn("Unsuccessful session saving operation!");
            }

        }
        else
        {
            exerciseSessionNameField.clear();
            exerciseDurationNameField.clear();

            exerciseSessionNameField.setPromptText("Invalid Input!");
            exerciseDurationNameField.setPromptText("Invalid Input!");

            Logger.error("Invalid Input!");
        }
    }

    @FXML
    public void onClickReset(){
        exerciseSessionNameField.setPromptText("Session Name");
        exerciseDurationNameField.setPromptText("Session length in hours");

        Logger.info("add TextFields reset");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    for (int i = 0; i < ExerciseWrapper.exerciseArrayList.size(); i++)
    {
        exerciseTypeChoiceBox.getItems().add(ExerciseWrapper.exerciseArrayList.get(i).getName()); //a choice box választásainak beállítása
    }

    intensityChoiceBox.getItems().add("Low Intesity");
    intensityChoiceBox.getItems().add("Normal Intesity");
    intensityChoiceBox.getItems().add("High Intesity");
    initializeMap();
    }
}
