package fitnessTracker2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A Simple class to validate integer and float inputs. Uses Regex.
 */
public class InputChecker {

    /**
     * Regex pattern for validating Integers, hopefully only compiles once per run.
     */
    public static Pattern onlyIntegerPattern = Pattern.compile("[0-9]+"); //I wish there was a constexpr in Java too

    /**
     * Regex pattern for validating floating point numbers, hopefully only compiles once per run.
     */
    public static Pattern onlyFloatPattern = Pattern.compile("[0-9]+([.][0-9]*)?|[.][0-9]+"); //regex to check if number is float, permits floats with no decimal parts

    /**
     * Simple method to check whatever a string contains only a valid integer.
     * @param str The String to be checked
     * @return Whatever the string only contains an Integer.
     */
    public static boolean onlyInteger(String str)
    {
        Matcher m = onlyIntegerPattern.matcher(str);

        return m.matches();

    }
    /**
     * Simple method to check whatever a string contains only a valid floating point number.
     * @param str The String to be checked
     * @return Whatever the string only contains a Floating Point Number.
     */
    public static boolean onlyFloat(String str)
    {
        Matcher m = onlyFloatPattern.matcher(str);

        return m.matches();
    }

}
