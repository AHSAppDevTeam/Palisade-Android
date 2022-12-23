package app.ahs.Palisade;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyViewModel extends ViewModel {

    // Expose screen UI state
    private MutableLiveData<List<PostsContents>> PostsContents;
    public LiveData<List<PostsContents>> getUsers() {
        if (PostsContents == null) {
            PostsContents = new MutableLiveData<List<PostsContents>>();
            loadUsers();
        }
        return PostsContents;
    }

    // Handle business logic
    private void loadUsers() {
        // Do an asynchronous operation to fetch users.
    }
}
