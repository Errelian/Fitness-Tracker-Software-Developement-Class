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
 * Controller class for save.fxml, mainly deals with saving of ExerciseType/ExerciseSession/Profile objects.
 */
public class SaveFxmlController implements Initializable {

    /**
     * ChoiceBox for choosing file type.
     */
    @FXML
    public ChoiceBox<JsonHandlerEnum> fileTypeChoiceBox;

    /**
     * The Action that fires when the button is clicked.
     * @param event Event Handler for closing the current window.
     * @throws IOException on IOException.
     */
    @FXML
    public void saveButtonAction(ActionEvent event) throws IOException {

        JsonHandlerEnum temp;
        if (fileTypeChoiceBox.getValue() != null)
        {
            temp = fileTypeChoiceBox.getValue();

            FileChooser fileChooser = new FileChooser();

            JsonHandler.save(temp,fileChooser.showSaveDialog(new Stage()));

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
