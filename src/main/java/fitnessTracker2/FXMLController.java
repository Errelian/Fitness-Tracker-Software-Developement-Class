package fitnessTracker2;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

public class FXMLController implements Initializable {

    @FXML
    private void loadButtonAction(ActionEvent event) {

        try {

            JsonHandler.load(JsonHandlerEnum.SESSION);

            Logger.info("Successful load!");
        }
        catch(Exception e)
        {
            Logger.error("Unsuccessful load!");
        }
    }

    @FXML
    private void saveButtonAction(ActionEvent event) {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        ArrayList<ExerciseSession> exerciseSessionArrayNonStatic = ExerciseSessionWrapper.exerciseSessionArrayList;

        try {
            writer.writeValue(Paths.get("exerciseTypeTest1.json").toFile(), exerciseSessionArrayNonStatic);
            Logger.info("Successful save!");
        }
        catch(Exception e)
        {
            Logger.error("Unsuccessful save!");
        }
    }

    @FXML
    private void addButtonAction(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/add.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Adding a New Session!");
            stage.setScene(scene);

            Logger.info("Successful FXML file opening!");
            stage.show();
        }
        catch(Exception e)
        {
            Logger.error("Unsuccessful FXML file opening!");
        }
    }

    @FXML
    private void editButtonAction(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/edit.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();


            stage.setTitle("Add a New Exercise Type!");
            stage.setScene(scene);

            Logger.info("Successful FXML file opening!");
            stage.show();
        }
        catch(Exception e)
        {
            Logger.error("Unsuccessful FXML file opening!");
        }
    }

    @FXML
    private void profileButtonAction(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/profile.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();

            stage.setTitle("Overwrite previous profile!");
            stage.setScene(scene);

            Logger.info("Successful FXML file opening!");

            stage.show();
        }
        catch(Exception e)
        {
            Logger.error("Unsuccessful FXML file opening!");
        }
    }

    @FXML
    private void graphButtonAction(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/graph.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();

            stage.setTitle("Graphing Window");
            stage.setScene(scene);

            Logger.info("Successful FXML file opening!");

            stage.show();
        }
        catch(Exception e)
        {
            Logger.error("Unsuccessful FXML file opening!");
        }
    }

    @FXML
    private void exitButtonAction(ActionEvent event){
        Logger.info("Exiting program...");

        Platform.exit();
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
