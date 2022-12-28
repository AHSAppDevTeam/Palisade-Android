package app.ahs.Palisade;

import java.util.ArrayList;
import java.util.HashMap;

public class PostsContents {

//    private HashMap<String, HashMap<String, String>> replies;
    private String message;
    private String UserID;

//    public HashMap<String, HashMap<String, String>> getReplies() {
//        return replies;
//    }
//
//    public void setReplies(HashMap<String, HashMap<String, String>> replies) {
//        this.replies = replies;
//    }

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
