package by.vet.validator;

import by.vet.dto.RegUserDataDTO;
import by.vet.entity.Role;
import by.vet.entity.Status;
import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Data
public class Validator {

    private static String emailRegexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private final static String  PASS_REGEX_PATTERN ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
   // private final static String  LOGIN_REGEX_PATTERN ="^[a-z]+([-_]?[a-z0-9]+){0,2}$";
    private final static String  LOGIN_REGEX_PATTERN ="^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$";
   // private final static String  NAME_REGEX_PATTERN ="^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)";
    private final static String  NAME_REGEX_PATTERN ="^([A-Z][a-z]*)([\\\\s\\\\\\'-][A-Z][a-z]*)*";

    public static boolean validateRegData(RegUserDataDTO user) {
    return  loginVal(user.getLogin_tel()) &&
             emailVal(user.getEmail()) &&
             nameVal(user.getName()) &&
             nameVal(user.getSurname()) &&
             passVal(user.getPass());
    }
    public static boolean emailVal(String emailAddress) {
        return Pattern.compile(emailRegexPattern).matcher(emailAddress).matches();
    }
    public static boolean passVal(String pass) {
        return Pattern.compile(PASS_REGEX_PATTERN).matcher(pass).matches();
    }
    public static boolean nameVal(String name) {
        return Pattern.compile(NAME_REGEX_PATTERN).matcher(name).matches();
    }
    public static boolean loginVal(String login) {
        return Pattern.compile(LOGIN_REGEX_PATTERN).matcher(login).matches();
    }
}
