import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static boolean validate(StudentDto dt){
        List<String> errors = new ArrayList<>();
        if (dt.getName().isBlank()) errors.add("name is required");
        if (dt.getEmail().isBlank() || !dt.getEmail().contains("@")) errors.add("email is invalid");
        if (dt.getPhone().isBlank() || !dt.getPhone().chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(dt.getProgram().equals("CSE") || dt.getProgram().equals("AI") || dt.getProgram().equals("SWE"))) errors.add("program is invalid");
        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return false;
        }else{
            return true;
        }

    }
}
