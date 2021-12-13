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


    public static boolean validateRegData(RegUserDataDTO user) {
    boolean rezult=false;
    String login = user.getLogin_tel(); //  latin_digit_cyr
    String mail = user.getEmail();       //                    +
    String name = user.getName();        //  latin xor cyr
    String surname= user.getSurname();   //  latin xor cyr
    String pass=user.getPass();          //  latin          +
    return false;
    }


    public static boolean emailPatternMatches(String emailAddress) {
        return Pattern.compile(emailRegexPattern).matcher(emailAddress).matches();
    }

    public static boolean passPatternMatches(String pass) {
        return Pattern.compile(PASS_REGEX_PATTERN).matcher(pass).matches();
    }

    //Pattern.compile(regex).matcher(input).matches()

//    public static boolean passPatternMatches1(String pass) {
//        Pattern pattern = Pattern.compile(PASS_REGEX_PATTERN);
//      //  System.out.println(pattern);
//
//        Matcher matcher = pattern.matcher(pass);
//        return matcher.matches();
//    }

}
