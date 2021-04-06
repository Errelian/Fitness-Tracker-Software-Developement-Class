package fitnessTracker2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class inputChecker {

    public static Pattern onlyIntegerPattern = Pattern.compile("[0-9]+"); //I wish there was a constexpr in Java too

    public static Pattern onlyFloatPattern = Pattern.compile("[0-9]+([.][0-9]*)?|[.][0-9]+"); //regex to check if number is float, permits floats with no decimal parts

    public static boolean onlyInteger(String str)
    {
        Matcher m = onlyIntegerPattern.matcher(str);

        return m.matches();

    }

    public static boolean onlyFloat(String str)
    {
        Matcher m = onlyFloatPattern.matcher(str);

        return m.matches();
    }

}
