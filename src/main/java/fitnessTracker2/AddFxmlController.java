package fitnessTracker2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
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


    public boolean validDuration(String Durations){

        if(Durations != null && !(Durations.equals("")) && InputChecker.onlyFloat(Durations))
        {
             double tempDouble = Double.parseDouble(Durations);
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

    public boolean validDate(LocalDate localDate){

        if (localDate != null)
        {
            Logger.info("Date successfully read!");

            tempDate = localDate;
            return true;
        }
        else
        {
            Logger.warn("Date reading unsuccessful!");
            return false;
        }
    }

    private boolean validName(){
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

    public static double calcCalorie(double weight, double cost, double intensity){
        return Math.round((weight / 70.0) * cost * intensity *10.0) / 10.0;
    }

    private boolean setCalories(){

        if (tempExercise !=null) {

            tempCalories = calcCalorie(ProfileWrapper.profile.getWeight(), tempExercise.getCalorieCost(), tempIntensity); //kalória becslés

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

        if(readExerciseChoiceBox() && setCode() && validName() && validDate(datePicker.getValue()) && validDuration(exerciseDurationNameField.getText())
                && readIntensityChoiceBox() && setCalories())
        {
            ExerciseSession tempSession = new ExerciseSession(tempCode, tempName,tempDate,tempDuration,tempExercise, tempCalories, tempIntensity);

            ExerciseSessionWrapper.append(tempSession);
            try {

                FileChooser fileChooser = new FileChooser();

                JsonHandler.save(JsonHandlerEnum.SESSION, fileChooser.showSaveDialog(new Stage()) );

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
