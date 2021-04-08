package fitnessTracker2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.pmw.tinylog.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;


public class MainApp extends Application {
    private static Stage stage;

    @Override
    public void start(@SuppressWarnings("exports") Stage s) throws IOException {
        stage=s;
        setRoot("primary","");
    }

    static void setRoot(String fxml) throws IOException {
        setRoot(fxml,stage.getTitle());
    }

    static void setRoot(String fxml, String title) throws IOException {
        Scene scene = new Scene(loadFXML(fxml));
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

        public static void main (String[]args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());

        Boolean launchChecker = Boolean.TRUE;

        try {
            ArrayList<exerciseSession> exerciseSessionArrayNonStatic = objectMapper.readValue(Paths.get("exerciseTypeTest1.json").toFile(), new TypeReference<ArrayList<exerciseSession>>() {});
            exerciseSessionWrapper.exerciseSessionArrayList = exerciseSessionArrayNonStatic;
        }
        catch (Exception e) {
            Logger.warn("Session file not found or otherwise inaccessible! Attempting to create it...");

            exercise Type1 = new exercise("Aerobic", 457);
            exerciseSession Sess1 = new exerciseSession(1, "My first exercise!", LocalDate.now(), Duration.ofHours(0), Type1, 0.0, 1);

            ArrayList<exerciseSession> tempArray = new ArrayList<exerciseSession>(){
                {
                    add(Sess1);
                }
            };
            try {
                writer.writeValue(Paths.get("exerciseTypeTest1.json").toFile(), tempArray);
            }
            catch(Exception e2)
            {
                Logger.error("Unable to create file!");

                launchChecker = Boolean.FALSE;
            }
        }



        try {
            ArrayList<exercise> exerciseArrayListNonStatic = objectMapper.readValue(Paths.get("exerciseTypes.json").toFile(), new TypeReference<ArrayList<exercise>>() {});

            exerciseWrapper.exerciseArrayList = exerciseArrayListNonStatic;

        }
        catch (Exception e)
        {
            Logger.warn("Type file not found or otherwise inaccessible! Attempting to create it...");

            exerciseWrapper.initialize();

            ArrayList<exercise> tempExercise = exerciseWrapper.exerciseArrayList;

            try{
                writer.writeValue(Paths.get("exerciseTypes.json").toFile(), tempExercise);
            }
            catch(Exception e2)
            {
                Logger.error("Unable to create file!");

                launchChecker = Boolean.FALSE;
            }

        }
        //System.out.println(exerciseSessionWrapper.exerciseSessionArrayList);

            try {
                profile profile = objectMapper.readValue(Paths.get("profile.json").toFile(), new TypeReference<profile>() {});

                profileWrapper.profile = profile;
            }
            catch(Exception e)
            {
                Logger.warn("Profile file not found or otherwise inaccessible! Attempting to create it...");

                profile profile = new profile("Joe Default", 70.0);

                profileWrapper.profile = profile;

                try {
                    writer.writeValue(Paths.get("profile.json").toFile(), profile);
                }
                catch(Exception e2)
                {
                    Logger.error("Unable to create file!");

                    launchChecker = Boolean.FALSE;
                }
            }
        //System.out.println(profileWrapper.profile);

        if (launchChecker) {
            launch(args);
        }
        else
        {
            Logger.error("Unable to create file(s)! Make sure the root folder isn't write protected!");
        }
    }

}
