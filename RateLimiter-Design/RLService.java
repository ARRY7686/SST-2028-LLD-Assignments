public class RLService {

    private RateLimiter rateLimiter;

    public RLService(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public boolean handleRequest(RequestDTO request) {
        return rateLimiter.allow(request);
    }
}