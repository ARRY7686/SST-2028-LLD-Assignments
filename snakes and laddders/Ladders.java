import java.util.*;

public class Ladders {
    public static Map<Integer, Integer> generate(int n) {
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(3, 22);
        ladders.put(8, 26);
        ladders.put(20, 29);
        return ladders;
    }
}