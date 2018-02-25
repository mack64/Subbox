package dk.subbox.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mmpa6 on 24-Feb-18.
 */

public class LoginHelperMethods {


    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }


    public static boolean isValidUsername(final String username){

        if (username.length() >= 6){
            return true;
        }else {
            return  false;
        }

    }

}
