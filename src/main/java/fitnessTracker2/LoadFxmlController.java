package fitnessTracker2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Simple FXML Controller class for load.fxml, mainly handles choosing the file type to be loaded.
 */
public class LoadFxmlController implements Initializable {

    /**
     * ChoiceBox for choosing the file Type.
     */
    @FXML
    public ChoiceBox<JsonHandlerEnum> fileTypeChoiceBox;

    /**
     * The event that fires when the button is pressed.
     * @param event Event handler for closing the current window.
     * @throws IOException on IOException.
     */
    @FXML
    public void loadButtonAction(ActionEvent event) throws IOException {
        JsonHandlerEnum temp;
        if (fileTypeChoiceBox.getValue() != null)
        {
            temp = fileTypeChoiceBox.getValue();

            FileChooser fileChooser = new FileChooser();

            JsonHandler.load(temp, false, fileChooser.showOpenDialog(new Stage()));

            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow(); //fogalmam sincs hogy miért csak így jó

            stage.close();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileTypeChoiceBox.getItems().add(JsonHandlerEnum.SESSION);
        fileTypeChoiceBox.getItems().add(JsonHandlerEnum.TYPE);
        fileTypeChoiceBox.getItems().add(JsonHandlerEnum.PROFILE);
    }
}
