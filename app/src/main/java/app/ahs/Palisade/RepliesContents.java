package app.ahs.Palisade;

public class RepliesContents {
    private String reply;
    private String user;
    private String MasterKey;

    public RepliesContents() {

    }

    public RepliesContents(String reply, String user, String Key) {
        this.reply = reply;
        this.user = user;
        this.MasterKey = Key;
    }

    public String getKey() {
        return MasterKey;
    }

    public void setKey(String key) {
        MasterKey = key;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
