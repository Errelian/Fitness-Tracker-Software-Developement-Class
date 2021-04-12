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
            JsonHandler.load(JsonHandlerEnum.SESSION, true);
        }
        catch (Exception e) {
            Logger.error("Session file not found or otherwise inaccessible!");

            launchChecker = Boolean.FALSE;
        }



        try {
            JsonHandler.load(JsonHandlerEnum.TYPE, true);

        }
        catch (Exception e)
        {
            Logger.error("Type file not found or otherwise inaccessible! Attempting to create it...");


            launchChecker = Boolean.FALSE;
        }

            try {
                JsonHandler.load(JsonHandlerEnum.PROFILE, true);
            }
            catch(Exception e)
            {
                Logger.error("Profile file not found or otherwise inaccessible! Attempting to create it...");

                launchChecker = Boolean.FALSE;
            }

        if (launchChecker) {

            File myFile1 = new File("session.json"); //a szükséges fájlokat létrehozza arra az esete ha a felhasználó nem akar custom helyre mentene
            File myFile2 = new File("type.json"); //a későbbiekben ezekre csak filechooser útján lesz utalva, ezik létrehozására mindig a rootban kerül sor
            File myFile3 = new File("profiles.json");

            try{
                myFile1.createNewFile();
                myFile2.createNewFile();
                myFile3.createNewFile();
            }
            catch(Exception e)
            {
                Logger.error("Trouble Creating files!");
            }
            launch(args);
        }
        else
        {
            Logger.error("Unable to create file(s)! Make sure the root folder isn't write protected!");
        }
    }

}
