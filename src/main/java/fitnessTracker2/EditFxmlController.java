package fitnessTracker2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EditFxmlController implements Initializable {

    public String tempExercise = "";

    public Integer tempCalorie = -1;

    @FXML
    public void onClickTextField(){

        exerciseCalorieField.setPromptText("Calories burned per hour per 70kg");

        exerciseNameField.setPromptText("Exercise Name");

        Logger.info("edit Textfields reset!");
    }

    @FXML
    public TextField exerciseNameField;

    @FXML
    public TextField exerciseCalorieField;

    @FXML
    public javafx.scene.control.Button saveButton;

    private boolean readName(){

        tempExercise = exerciseNameField.getText(); //bármilyen sztringet elfogad, nem látom értelméd a számok kiszűrésének

        Logger.info("Name successfully read!");

        return true;
    }

    private boolean readCalorie(){

        String something;

        something = exerciseCalorieField.getText();


        if (something != null && !(something.equals("")) && InputChecker.onlyInteger(something) ) {

            tempCalorie = Integer.valueOf(something);

            Logger.info("Calorie value successfully read!");

            return true;
        }
        else
        {

            exerciseCalorieField.clear();
            exerciseCalorieField.setPromptText("Invalid input!");

            Logger.warn("Calorie value unsuccessfully read!");

            return false;
        }


    }


    @FXML
    private void saveExerciseType(ActionEvent event) throws IOException {

        if (readCalorie() && readName()) {

            Exercise exerciseToBeAdded = new Exercise(tempExercise, tempCalorie);

            ExerciseWrapper.exerciseArrayList.add(exerciseToBeAdded);

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            try {
                ArrayList<Exercise> exerciseArrayNonStatic = ExerciseWrapper.exerciseArrayList;
                writer.writeValue(Paths.get("exerciseTypes.json").toFile(), exerciseArrayNonStatic);

                final Node source = (Node) event.getSource();
                final Stage stage = (Stage) source.getScene().getWindow(); //I have no idea why it only works like this

                Logger.info("Successful edit save operation!");

                stage.close();
            }
            catch(Exception e)
            {
                Logger.error("Error during edit save operation!");
            }
        }
        else
        {
            exerciseCalorieField.clear();

            exerciseNameField.clear();

            exerciseCalorieField.setPromptText("Invalid input!");

            exerciseNameField.setPromptText("Invalid input!");

            Logger.warn("Invalid edit input!");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
