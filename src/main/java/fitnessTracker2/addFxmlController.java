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

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class addFxmlController implements Initializable {

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
    private exercise tempExercise;
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

        if(tempString != null && !(tempString.equals("")) && inputChecker.onlyFloat(tempString))
        {
             double tempDouble = Double.parseDouble(tempString);
             if (tempDouble < 73.0)
             {
                 Long tempLong = Math.round(3600 * tempDouble);

                 //System.out.println(tempLong);

                 tempDuration = Duration.ofSeconds(tempLong);
                 //System.out.println(tempDuration);

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
            tempString = exerciseTypeChoiceBox.getValue();

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

    private boolean readIntensityChoiceBox(){
        tempString = "";
        if (intensityChoiceBox.getValue() != null)
        {
            tempString = intensityChoiceBox.getValue();

            if( !(tempString.equals("")) ) {
                tempIntensity = (Double) intensityMap.getOrDefault(tempString, "1.00");

                //System.out.print(tempIntensity);
                return true;
            }
        }
            return false;
    }

    private boolean setCalories(){

        if (tempExercise !=null) {

            tempCalories = (profileWrapper.profile.getWeight() / 70.0) * tempExercise.getCalorieCost() * tempIntensity;

            return true;
        }
        else {
            return false;
        }
    }

    @FXML
    public void saveButtonAction(ActionEvent event) throws IOException {

        if(readExerciseChoiceBox() && setCode() && readName() && readDate() && readDuration() && readIntensityChoiceBox() && setCalories())
        {
            exerciseSession tempSession = new exerciseSession(tempCode, tempName,tempDate,tempDuration,tempExercise, tempCalories, tempIntensity);

            //System.out.println(tempSession);

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);


            exerciseSessionWrapper.append(tempSession);

            ArrayList<exerciseSession> exerciseSessionArrayListNonStatic = exerciseSessionWrapper.exerciseSessionArrayList;

            writer.writeValue(Paths.get("exerciseTypeTest1.json").toFile(), exerciseSessionArrayListNonStatic);

            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow(); //fogalmam sincs hogy miért csak így jó

            stage.close();

        }
        else
        {
            exerciseSessionNameField.clear();
            exerciseDurationNameField.clear();

            exerciseSessionNameField.setPromptText("Invalid Input!");
            exerciseDurationNameField.setPromptText("Invalid Input!");
        }
    }

    @FXML
    public void onClickReset(){
        exerciseSessionNameField.setPromptText("Session Name");
        exerciseDurationNameField.setPromptText("Session length in hours");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    for (int i = 0; i < exerciseWrapper.exerciseArrayList.size(); i++)
    {
        exerciseTypeChoiceBox.getItems().add(exerciseWrapper.exerciseArrayList.get(i).getName()); //a choice box választásainak beállítása
    }

    intensityChoiceBox.getItems().add("Low Intesity");
    intensityChoiceBox.getItems().add("Normal Intesity");
    intensityChoiceBox.getItems().add("High Intesity");
    initializeMap();
    }
}
