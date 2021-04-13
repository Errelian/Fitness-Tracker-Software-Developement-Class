package fitnessTracker2;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Class to Handle Json Save/Load.
 */
public class JsonHandler {


    /**
     * @param fileType The Type of the file that needs to be loaded, enum.
     * @param loadDefault Boolean, whatever the default values need to be loaded.
     * @param file The Filepath to the desired file.
     * @return Whatever the file reading was successful.
     * @throws IOException on IOException.
     */
    public static boolean load(JsonHandlerEnum fileType, Boolean loadDefault, File file) throws IOException{

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        ClassLoader classLoader = JsonHandler.class.getClassLoader();

        if(loadDefault.equals(true)) {
            if (fileType == JsonHandlerEnum.SESSION) {
                ArrayList<ExerciseSession> exerciseSessionArrayNonStatic = objectMapper.readValue(classLoader.getResource("exerciseTypeTest1.json"), new TypeReference<ArrayList<ExerciseSession>>() {
                });


                if (exerciseSessionArrayNonStatic == null) {
                    return false;
                } else {
                    ExerciseSessionWrapper.exerciseSessionArrayList = exerciseSessionArrayNonStatic;

                    return true;
                }
            } else if (fileType == JsonHandlerEnum.TYPE) {
                ArrayList<Exercise> exerciseArrayNonStatic = objectMapper.readValue(classLoader.getResource("exerciseTypes.json"), new TypeReference<ArrayList<Exercise>>() {
                });

                if (exerciseArrayNonStatic == null) {
                    return false;
                } else {
                    ExerciseWrapper.exerciseArrayList = exerciseArrayNonStatic;

                    return true;
                }
            } else {
                Profile profile = objectMapper.readValue(classLoader.getResource("profile.json"), new TypeReference<Profile>() {
                });

                if (profile == null) {
                    return false;
                } else {
                    ProfileWrapper.profile = profile;

                    return true;
                }
            }
        }
        {
            if(fileType == JsonHandlerEnum.SESSION)
            {

                ArrayList<ExerciseSession> exerciseSessionArrayNonStatic = objectMapper.readValue(file, new TypeReference<ArrayList<ExerciseSession>>() {
                });

                if (exerciseSessionArrayNonStatic == null) {
                    return false;
                } else {
                    ExerciseSessionWrapper.exerciseSessionArrayList = exerciseSessionArrayNonStatic;

                    //System.out.println(ExerciseSessionWrapper.exerciseSessionArrayList);

                    return true;
                }

            }
            else if(fileType == JsonHandlerEnum.TYPE)
            {

                ArrayList<Exercise> exerciseArrayNonStatic = objectMapper.readValue(file, new TypeReference<ArrayList<Exercise>>() {
                });

                if (exerciseArrayNonStatic == null) {
                    return false;
                } else {
                    ExerciseWrapper.exerciseArrayList = exerciseArrayNonStatic;

                    //System.out.println(ExerciseWrapper.exerciseArrayList);

                    return true;
                }


            }
            else if(fileType == JsonHandlerEnum.PROFILE)
            {

                Profile profile = objectMapper.readValue(file, new TypeReference<Profile>() {
                });

                if (profile == null) {
                    return false;
                } else {
                    ProfileWrapper.profile = profile;

                    //System.out.println(ProfileWrapper.profile);

                    return true;
                }

            }
        }
        return false;
    }

    /**
     * @param fileType The Type of the file that needs to be saved, enum.
     * @return Boolean, whatever the saving was successful or not.
     * @throws IOException on IOException.
     */
    public static boolean save(JsonHandlerEnum fileType, File filePath) throws IOException{

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);


        if(fileType == JsonHandlerEnum.SESSION)
        {

            ArrayList<ExerciseSession> exerciseSessionArrayListNonStatic = ExerciseSessionWrapper.exerciseSessionArrayList;


            writer.writeValue(filePath, exerciseSessionArrayListNonStatic);

            return true;

        }
        else if(fileType == JsonHandlerEnum.TYPE)
        {

            ArrayList<Exercise> exerciseArrayListNonStatic = ExerciseWrapper.exerciseArrayList;


            writer.writeValue(filePath, exerciseArrayListNonStatic);

            return true;

        }
        else if(fileType == JsonHandlerEnum.PROFILE)
        {

            Profile profile = ProfileWrapper.profile;


            writer.writeValue(filePath, profile);

            return true;

        }

        return false;
    }
}
