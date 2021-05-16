package fitnessTracker2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML controller class for profile.fxml. Mainly handles the creation and saving of new profile objects.
 */
public class ProfileController implements Initializable {

    /**
     * TextField for reading the profile name.
     */
    @FXML
    public TextField profileNameTextField;
    /**
     * TextField for reading the user's weight.
     */
    @FXML
    public TextField bodyWeightTextField;
    /**
     * TextField for reading the user's height.
     */
    @FXML
    public TextField bodyHeightTextField;

    /**
     * @param height The user's height.
     * @param weight The user's weight.
     * @return The calculated BMI.
     */
    public static Double calcBmi(Double height, Double weight)
    {
        height = height /100.0;

        return Math.round(weight / (height * height) * 10.0) /10.0; //nagyon csúnya 1 tizedesjegyre kerekítés
    }

    /**
     * @param event Event Handler for closing down the window.
     * @throws IOException on IOException.
     */
    @FXML
    public void saveButtonAction(ActionEvent event) throws IOException{
        String tempName = profileNameTextField.getText();
        String tempWeightString = bodyWeightTextField.getText();
        String tempHeightString = bodyHeightTextField.getText();

        if (InputChecker.onlyFloat(tempWeightString) && InputChecker.onlyFloat(tempHeightString))
        {
            ProfileWrapper.profile.setWeight(Double.parseDouble(tempWeightString));
            ProfileWrapper.profile.setName(tempName);
            ProfileWrapper.profile.setHeight(Double.parseDouble(tempHeightString));
            ProfileWrapper.profile.setBmi(calcBmi(Double.parseDouble(tempHeightString), Double.parseDouble(tempWeightString)));

            FileChooser fileChooser = new FileChooser();

            JsonHandler.save(JsonHandlerEnum.PROFILE, fileChooser.showSaveDialog(new Stage()));

            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow(); //fogalmam sincs hogy miért csak így jó

            stage.close();
        }
        else
        {
            bodyWeightTextField.clear();
            bodyHeightTextField.clear();
            bodyWeightTextField.setPromptText("Invalid number!");
            bodyHeightTextField.setPromptText("Invalid number!");
        }
    }

    /**
     * Simple method to reset prompt text when clicked.
     */
    @FXML
    public void onClickReset(){
        bodyWeightTextField.setPromptText("Enter your body weight!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
