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

        public static void main (String[]args) {

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());

        Boolean launchChecker = Boolean.TRUE;

        try {
            ArrayList<ExerciseSession> exerciseSessionArrayNonStatic = objectMapper.readValue(Paths.get("exerciseTypeTest1.json").toFile(), new TypeReference<ArrayList<ExerciseSession>>() {});
            ExerciseSessionWrapper.exerciseSessionArrayList = exerciseSessionArrayNonStatic;
        }
        catch (Exception e) {
            Logger.warn("Session file not found or otherwise inaccessible! Attempting to create it...");

            Exercise Type1 = new Exercise("Aerobic", 457);
            ExerciseSession Sess1 = new ExerciseSession(1, "My first exercise!", LocalDate.now(), Duration.ofHours(0), Type1, 0.0, 1);

            ArrayList<ExerciseSession> tempArray = new ArrayList<ExerciseSession>(){
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
            ArrayList<Exercise> exerciseArrayListNonStatic = objectMapper.readValue(Paths.get("exerciseTypes.json").toFile(), new TypeReference<ArrayList<Exercise>>() {});

            ExerciseWrapper.exerciseArrayList = exerciseArrayListNonStatic;

        }
        catch (Exception e)
        {
            Logger.warn("Type file not found or otherwise inaccessible! Attempting to create it...");

            ExerciseWrapper.initialize();

            ArrayList<Exercise> tempExercise = ExerciseWrapper.exerciseArrayList;

            try{
                writer.writeValue(Paths.get("exerciseTypes.json").toFile(), tempExercise);
            }
            catch(Exception e2)
            {
                Logger.error("Unable to create file!");

                launchChecker = Boolean.FALSE;
            }

        }

            try {
                Profile profile = objectMapper.readValue(Paths.get("profile.json").toFile(), new TypeReference<Profile>() {});

                ProfileWrapper.profile = profile;
            }
            catch(Exception e)
            {
                Logger.warn("Profile file not found or otherwise inaccessible! Attempting to create it...");

                Profile profile = new Profile("Joe Default", 70.0);

                ProfileWrapper.profile = profile;

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
