package app.ahs.Palisade;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class UserPost extends AppCompatDialogFragment {
    private EditText editPost;
    private NewPostsListener listener;
    private DatabaseReference mDatabase;

    SharedPreferences sp;
    SharedPreferences amongus;
    String UserUUID;
    String title;

    public UserPost(String title) {
        this.title = title;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        sp = getActivity().getSharedPreferences("UUID", Context.MODE_PRIVATE);
        UserUUID = sp.getString("UUID", "");
        long messageTime = new Date().getTime();

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_post, null);

        builder.setView(view)
                .setTitle("Your Post")

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String post = editPost.getText().toString();
                        PostsContents postsContents = new PostsContents(post, UserUUID, null);
                        Log.d("amongus", postsContents.toString());
//                        will send to database and then refresh using the refresh code wtih firebase
                        if (post.isEmpty()) {
//                            Toast.makeText(, "", Toast.LENGTH_SHORT).show();
                        } else {
                            mDatabase.child("palisade").child(title).child(String.valueOf(messageTime)).setValue(postsContents);
                        }

//                        listener.applyTexts(post);

                    }
                });

        editPost = view.findViewById(R.id.post);

        return builder.create();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try {
            listener = (NewPostsListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "null");
        }
    }

    public interface NewPostsListener{
        void applyTexts(String post);
    }
}
