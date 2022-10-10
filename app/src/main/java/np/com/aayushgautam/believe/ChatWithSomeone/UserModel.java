package np.com.aayushgautam.believe.ChatWithSomeone;

public class UserModel {
    private String userId;
    private long sessionId;

    public UserModel() {
    }

    public UserModel(String userId, long sessionId) {
        this.userId = userId;
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }
}
