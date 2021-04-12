package fitnessTracker2;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    public TextField profileNameTextField;
    @FXML
    public TextField bodyWeightTextField;
    @FXML
    public TextField bodyHeightTextField;

    public static Double calcBmi(Double height, Double weight)
    {
        height = height /100.0;

        return Math.round(weight / (height * height) * 10.0) /10.0; //nagyon csúnya 1 tizedesjegyre kerekítés
    }

    @FXML
    public void saveButtonAction(ActionEvent event) throws IOException, URISyntaxException {
        String tempName = profileNameTextField.getText();
        String tempWeightString = bodyWeightTextField.getText();
        String tempHeightString = bodyHeightTextField.getText();

        if (InputChecker.onlyFloat(tempWeightString) && InputChecker.onlyFloat(tempHeightString))
        {
            ProfileWrapper.profile.setWeight(Double.parseDouble(tempWeightString));
            ProfileWrapper.profile.setName(tempName);
            ProfileWrapper.profile.setHeight(Double.parseDouble(tempHeightString));
            ProfileWrapper.profile.setBmi(calcBmi(Double.parseDouble(tempHeightString), Double.parseDouble(tempWeightString)));

            JsonHandler.save(JsonHandlerEnum.PROFILE);

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

    @FXML
    public void onClickReset(MouseEvent event){
        bodyWeightTextField.setPromptText("Enter your body weight!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
