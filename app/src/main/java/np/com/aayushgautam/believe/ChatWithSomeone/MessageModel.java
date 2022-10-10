package np.com.aayushgautam.believe.ChatWithSomeone;

public class MessageModel {
    private String userId;
    private long sessionId;
    private boolean sent;
    private String Message;

    public MessageModel() {
    }

    public MessageModel(String userId, long sessionId, boolean sent, String message) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.sent = sent;
        Message = message;
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

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
