public class RateLimiter {

    private RLStrategy strategy;

    public RateLimiter(RLStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean allow(RequestDTO request) {
        return strategy.validateRequest(request);
    }
}