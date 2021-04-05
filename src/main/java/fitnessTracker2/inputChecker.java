package fitnessTracker2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class inputChecker {

    public static Pattern onlyIntegerPattern = Pattern.compile("[0-9]+"); //I wish there was a constexpr in Java too

    public static boolean onlyInteger(String str)
    {
        Matcher m = onlyIntegerPattern.matcher(str);

        return m.matches();

    }

}
