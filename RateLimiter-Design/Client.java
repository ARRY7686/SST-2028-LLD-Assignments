public class Client {

    public static void main(String[] args) throws InterruptedException {

        RLStrategy strategy = RLFactory.getRL("SLIDING_WINDOW");
        RateLimiter rateLimiter = new RateLimiter(strategy);
        RLService rlService = new RLService(rateLimiter);
        API api = new API(rlService);

        String user = "user1";

        for (int i = 0; i < 10; i++) {
            RequestDTO request = new RequestDTO(
                    user,
                    "api-key",
                    "127.0.0.1",
                    System.currentTimeMillis()
            );

            boolean allowed = api.process(request);

            System.out.println("Request " + i + " allowed: " + allowed);

            Thread.sleep(1000); // simulate delay
        }
    }
}