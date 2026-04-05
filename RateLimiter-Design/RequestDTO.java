public class RequestDTO {
    private String userId;
    private String key;
    private String ip;
    private long timestamp;

    public RequestDTO(String userId, String key, String ip, long timestamp) {
        this.userId = userId;
        this.key = key;
        this.ip = ip;
        this.timestamp = timestamp;
    }

    public String getUserId() { return userId; }
    public String getKey() { return key; }
    public String getIp() { return ip; }
    public long getTimestamp() { return timestamp; }
}