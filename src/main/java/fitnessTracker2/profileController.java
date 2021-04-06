package fitnessTracker2;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;

public class profileController {

    @FXML
    public TextField profileNameTextField;
    @FXML
    public TextField bodyWeightTextField;

    private String tempName;
    private String tempWeightString;

    @FXML
    public void saveButtonAction(ActionEvent event) throws IOException {
        tempName = profileNameTextField.getText();
        tempWeightString = bodyWeightTextField.getText();

        if (inputChecker.onlyFloat(tempWeightString))
        {
            profileWrapper.profile.setWeight(Double.parseDouble(tempWeightString));
            profileWrapper.profile.setName(tempName);

            profile profile =  new profile( profileWrapper.profile.getName(),  profileWrapper.profile.getWeight());

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("profile.json").toFile(), profile);

            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow(); //fogalmam sincs hogy miért csak így jó

            stage.close();
        }
        else
        {
            bodyWeightTextField.clear();
            bodyWeightTextField.setPromptText("Invalid number!");
        }
    }

    @FXML
    public void onClickReset(MouseEvent event){
        bodyWeightTextField.setPromptText("Enter your body weight!");
    }

}
