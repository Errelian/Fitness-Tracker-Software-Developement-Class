package fitnessTracker2;
/*
Put header here


 */

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLController implements Initializable {
    
    @FXML
    private Label lblOut;
    
    @FXML
    private void btnClickAction(ActionEvent event) {
        lblOut.setText("Hello World!");
    }

    @FXML
    private void loadButtonAction(ActionEvent event) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        ArrayList<exerciseSession> exerciseSessionArrayNonStatic = objectMapper.readValue(Paths.get("exerciseTypeTest1.json").toFile(), new TypeReference<ArrayList<exerciseSession>>() {});

        exerciseSessionWrapper.exerciseSessionArrayList = exerciseSessionArrayNonStatic; //NAGYON CSÚNYA HACK

        //lblOut.setText(exerciseSessionWrapper.exerciseSessionArrayList.toString());
    }

    @FXML
    private void saveButtonAction(ActionEvent event) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        /*exercise Type1 = new exercise("Aerobic", 457);
        exercise Type2 = new exercise("Archery", 246);

        exerciseSession Sess1 = new exerciseSession(1, "Reggeli Aerobic 1", ZonedDateTime.now(), Duration.ofHours(2), Type1, 914.0, 1);
        exerciseSession Sess2 = new exerciseSession(2, "Délutáni Íjászat",ZonedDateTime.now().plus(Duration.ofHours(5)), Duration.ofHours(2), Type2, 592.0, 1);

        exerciseSessionWrapper exerciseSessionArray = new exerciseSessionWrapper(Sess1);
        exerciseSessionArray.append(Sess2);*/

        ArrayList<exerciseSession> exerciseSessionArrayNonStatic = exerciseSessionWrapper.exerciseSessionArrayList; //FÚNE

        writer.writeValue(Paths.get("exerciseTypeTest1.json").toFile(), exerciseSessionArrayNonStatic);

    }

    @FXML
    private void addButtonAction(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/add.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();

        stage.setResizable(false);
        stage.setTitle("Adding a New Session!");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void editButtonAction(ActionEvent event) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/edit.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();

        stage.setResizable(false);
        stage.setTitle("Add a New Exercise Type!");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void profileButtonAction(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/profile.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();

        stage.setResizable(false);
        stage.setTitle("Overwrite previous profile!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
