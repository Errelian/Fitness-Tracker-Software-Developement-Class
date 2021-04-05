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

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class editFxmlController implements Initializable {

    public String tempExercise = "";

    public Integer tempCalorie = -1;

    @FXML
    public void onClickTextField(){

        exerciseCalorieField.setPromptText("Calories burned per hour per 70kg");

        exerciseNameField.setPromptText("Exercise Name");
    }

    @FXML
    public TextField exerciseNameField;

    @FXML
    public TextField exerciseCalorieField;

    @FXML
    public javafx.scene.control.Button saveButton;

    private boolean readName(){

        tempExercise = exerciseNameField.getText(); //bármilyen sztringet elfogad, nem látom értelméd a számok kiszűrésének

        return true;
    }

    private boolean readCalorie(){

        //System.out.println("Jó 1");

        String something;

        something = exerciseCalorieField.getText();

        //System.out.println("Jó 2");

        if ( !(something.equals(null)) && !(something.equals("")) && inputChecker.onlyInteger(something) ) {

            tempCalorie = Integer.valueOf(something);

            return true;
        }
        else
        {

            exerciseCalorieField.clear();
            exerciseCalorieField.setPromptText("Invalid input!");

            return false;
        }
        //System.out.println("Jó 3");


    }


    @FXML
    private void saveExerciseType(ActionEvent event) throws IOException {

        if (readCalorie() && readName()) {

            exercise exerciseToBeAdded = new exercise(tempExercise, tempCalorie);

            exerciseWrapper.exerciseArrayList.add(exerciseToBeAdded);

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            ArrayList<exercise> exerciseArrayNonStatic = exerciseWrapper.exerciseArrayList;
            writer.writeValue(Paths.get("exerciseTypes.json").toFile(), exerciseArrayNonStatic);

            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow(); //fogalmam sincs hogy miért csak így jó

            stage.close();
        }
        else
        {
            exerciseCalorieField.clear();

            exerciseNameField.clear();

            exerciseCalorieField.setPromptText("Invalid input!");

            exerciseNameField.setPromptText("Invalid input!");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
