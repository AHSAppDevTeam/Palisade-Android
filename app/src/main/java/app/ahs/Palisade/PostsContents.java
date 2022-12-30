package app.ahs.Palisade;

import java.util.ArrayList;
import java.util.HashMap;

public class PostsContents {

//    private HashMap<String, HashMap<String, String>> replies;
    private String message;
    private String UserID;
    private String key;

//    public HashMap<String, HashMap<String, String>> getReplies() {
//        return replies;
//    }
//
//    public void setReplies(HashMap<String, HashMap<String, String>> replies) {
//        this.replies = replies;
//    }

    public PostsContents() {

    }

    public PostsContents(String message, String userID, String key) {
        this.message = message;
        this.UserID = userID;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return UserID;
    }

    public void setUser(String user) {
        this.UserID = user;
    }
}
