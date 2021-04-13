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

/**
 * Simple controller class for primary.fxml.
 */
public class FXMLController implements Initializable {

    @FXML
    private void loadButtonAction(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/Load.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Load!");
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
    private void saveButtonAction(ActionEvent event) {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/save.fxml"));

        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();

            stage.setResizable(false);
            stage.setTitle("Save!");
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
    }    
}
