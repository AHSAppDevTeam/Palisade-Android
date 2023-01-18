package app.ahs.Palisade;

import android.content.Intent;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class PostsViewModel extends ViewModel {

    public static final String topicNameID = "topicNameID";
    //get title that the user has input

    private String title;





    // Expose screen UI state
    private MutableLiveData<List<PostsContents>> PostsContents;
    public LiveData<List<PostsContents>> getPostsContents() {
        if (PostsContents == null) {
            PostsContents = new MutableLiveData<List<PostsContents>>();
            loadPostContents();
        }
        return PostsContents;
    }


    // Handle business logic
    private void loadPostContents() {
//        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("palisade/" + );
    }

}
