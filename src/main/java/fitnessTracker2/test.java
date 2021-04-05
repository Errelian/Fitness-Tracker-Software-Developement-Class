package fitnessTracker2;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.val;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class test {
    public static void main01(String[] args) throws IOException {

       /* exercise Type1 = new exercise("Aerobic", 457);

        exercise Type2 = new exercise("Archery", 246);

        exerciseSession Sess1 = new exerciseSession(1, "Reggeli Aerobic 1", ZonedDateTime.now(), Duration.ofHours(2), Type1, 914.0, 1);

        exerciseSession Sess2 = new exerciseSession(2, "Délutáni Íjászat",ZonedDateTime.now().plus(Duration.ofHours(5)), Duration.ofHours(2), Type2, 592.0, 1);

        exerciseSessionWrapper exerciseSessionArray = new exerciseSessionWrapper(Sess1);

        exerciseSessionArray.append(Sess2);

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());

        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());

        writer.writeValue(Paths.get("exerciseTypeTest1.json").toFile(), exerciseSessionArray);

        exerciseSessionWrapper testArray = objectMapper.readValue(Paths.get("exerciseTypeTest1.json").toFile(), exerciseSessionWrapper.class);

        System.out.println(testArray);*/

        //String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(exerciseSessionArray);

        //System.out.println(json);

        //File file = new File("exerciseTypeTest1.json");

        //FileWriter fileWriter = new FileWriter(file, true); //utálom, úgy lesz majd appendelve hogy belolvas -> object listává alakítás -> új dolgok hozzáadáa -> fájl overwrite

        //SequenceWriter sequenceWriter = objectMapper.writerWithDefaultPrettyPrinter().writeValuesAsArray(fileWriter);

        //sequenceWriter.writeAll(Collections.singleton(Type1));

        //sequenceWriter.close();

        /*
        ObjectMapper objectMapper = new ObjectMapper();

        exercise Type1 = new exercise("Aerobic", 457);
        exercise Type2 = new exercise("Archery", 246);

        exercise Type3 = new exercise("Hiking", 493);
        exercise Type4 = new exercise("Badminton", 317);

        exercise Type5 = new exercise("Ballet", 317);
        exercise Type6 = new exercise("Boxing", 844);

        exercise Type7 = new exercise("Basketball", 422);
        exercise Type8 = new exercise("Fishing", 211);

        exercise Type9 = new exercise("Football", 633);
        exercise Type10 = new exercise("Golf", 317);

        exerciseWrapper exerciseArrayList = new exerciseWrapper(Type1);

        exerciseWrapper.exerciseArrayList.add(Type2);
        exerciseWrapper.exerciseArrayList.add(Type3);
        exerciseWrapper.exerciseArrayList.add(Type4);
        exerciseWrapper.exerciseArrayList.add(Type5);
        exerciseWrapper.exerciseArrayList.add(Type6);
        exerciseWrapper.exerciseArrayList.add(Type7);
        exerciseWrapper.exerciseArrayList.add(Type8);
        exerciseWrapper.exerciseArrayList.add(Type9);
        exerciseWrapper.exerciseArrayList.add(Type10);

        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());


        ArrayList<exercise> exerciseArrayListNonStatic = exerciseWrapper.exerciseArrayList;

        writer.writeValue(Paths.get("exerciseTypes.json").toFile(), exerciseArrayListNonStatic);*/
    }
}
