package fitnessTracker2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for edit.fxml.
 */
public class EditFxmlController implements Initializable {

    /**
     * Temporary variable.
     */
    public String tempExercise = "";

    /**
     * Temporary variable.
     */
    public Integer tempCalorie = -1;

    /**
     * Simple clearing action for clarity.
     */
    @FXML
    public void onClickTextField(){

        exerciseCalorieField.setPromptText("Calories burned per hour per 70kg");

        exerciseNameField.setPromptText("Exercise Name");

        Logger.info("edit Textfields reset!");
    }

    /**
     * TextField for reading the exercise type name.
     */
    @FXML
    public TextField exerciseNameField;
    /**
     * TextField for reading the exercise type KCaloric cost.
     */
    @FXML
    public TextField exerciseCalorieField;

    /**
     * The Save button.
     */
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
    private void saveExerciseType(ActionEvent event){

        if (readCalorie() && readName()) {

            Exercise exerciseToBeAdded = new Exercise(tempExercise, tempCalorie);

            ExerciseWrapper.exerciseArrayList.add(exerciseToBeAdded);

            try {

                FileChooser fileChooser = new FileChooser();

                JsonHandler.save(JsonHandlerEnum.TYPE, fileChooser.showSaveDialog(new Stage()));

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
