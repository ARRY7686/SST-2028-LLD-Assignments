public class API {

    private RLService rlService;

    public API(RLService rlService) {
        this.rlService = rlService;
    }

    public boolean process(RequestDTO request) {
        return rlService.handleRequest(request);
    }
}