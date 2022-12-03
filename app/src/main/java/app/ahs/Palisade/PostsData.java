package app.ahs.Palisade;

import android.widget.Button;

public class PostsData {
    private String message;
    private String user;



    public PostsData(String user, String message) {
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }
    public String getUser() {
        return user;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(String message) {
        this.message = user;
    }

}
