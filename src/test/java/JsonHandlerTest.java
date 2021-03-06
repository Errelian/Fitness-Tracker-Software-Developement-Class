import fitnessTracker2.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonHandlerTest {

    @Test
    public void loadTest() throws IOException {
        Exercise Type1 = new Exercise("Aerobic", 457);

        ExerciseSession Sess1 = new ExerciseSession(0, "Reggeli Aerobic 1", LocalDate.of(2021, 4, 13), Duration.ofHours(2), Type1, 914.0, 1);

        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(Objects.requireNonNull(classLoader.getResource("sessionTest.json")).getFile());

        JsonHandler.load(JsonHandlerEnum.SESSION, false, file);

        boolean temp = Sess1.equals(ExerciseSessionWrapper.exerciseSessionArrayList.get(0)); //megnézzük hogy a létrehozott objektum megfelel-e az elvártnak

        assertTrue(temp);

    }

    @Test
    public void saveTest() throws IOException {
        var file = new File("./test.json");
        ClassLoader classLoader = getClass().getClassLoader();

        JsonHandler.load(JsonHandlerEnum.SESSION, false, new File(Objects.requireNonNull(classLoader.getResource("sessionTest.json")).getFile()));

        ExerciseSession Sess1 = ExerciseSessionWrapper.exerciseSessionArrayList.get(0);

        JsonHandler.save(JsonHandlerEnum.SESSION, file);

        JsonHandler.load(JsonHandlerEnum.SESSION, false, file);

        boolean temp = Sess1.equals(ExerciseSessionWrapper.exerciseSessionArrayList.get(0));

        assertTrue(temp);
    }
}