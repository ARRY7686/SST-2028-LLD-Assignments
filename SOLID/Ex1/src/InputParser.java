import java.util.LinkedHashMap;
import java.util.Map;

public class InputParser {
    public static StudentDto parse(String raw){
        StudentDto dt = new StudentDto();
        Map<String,String> kv = new LinkedHashMap<>();
        String[] parts = raw.split(";");
        for (String p : parts) {
            String[] t = p.split("=", 2);
            if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        }

        dt.setName(kv.getOrDefault("name", ""));
        dt.setEmail(kv.getOrDefault("email", ""));
        dt.setPhone(kv.getOrDefault("phone", ""));
        dt.setProgram(kv.getOrDefault("program", ""));
        return dt;


    }
}
