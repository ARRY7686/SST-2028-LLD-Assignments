public class RLFactory {

    public static RLStrategy getRL(String type) {
        if ("SLIDING_WINDOW".equalsIgnoreCase(type)) {
            return new SlidingWindowStrategy(5, 10_000); // 5 req per 10 sec
        }

        throw new IllegalArgumentException("Unknown strategy: " + type);
    }
}