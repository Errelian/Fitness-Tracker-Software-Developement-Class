package fitnessTracker2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Simple controller class for primary.fxml. Mainly handles the loading of other stages.
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
