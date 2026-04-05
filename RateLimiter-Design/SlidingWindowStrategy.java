import java.util.*;

public class SlidingWindowStrategy implements RLStrategy {

    private final int maxRequests;
    private final long windowSizeMillis;

    private final Map<String, Deque<Long>> userRequests = new HashMap<>();

    public SlidingWindowStrategy(int maxRequests, long windowSizeMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeMillis = windowSizeMillis;
    }

    @Override
    public boolean validateRequest(RequestDTO request) {
        long now = request.getTimestamp();
        String userId = request.getUserId();

        userRequests.putIfAbsent(userId, new LinkedList<>());
        Deque<Long> timestamps = userRequests.get(userId);

        // Remove old timestamps
        while (!timestamps.isEmpty() && now - timestamps.peekFirst() > windowSizeMillis) {
            timestamps.pollFirst();
        }

        if (timestamps.size() >= maxRequests) {
            return false;
        }

        timestamps.addLast(now);
        return true;
    }
}