package app.ahs.Palisade;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class UserMessage extends AppCompatDialogFragment {
    private EditText editTextMessage;
    private UserMessageListener listener;
    PostsMenu postsMenu =  new PostsMenu();
    private DatabaseReference mDatabase;
    SharedPreferences sp;
    SharedPreferences amongus;
    String titles;
    String UserUUID;




    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        sp = getActivity().getSharedPreferences("UUID", Context.MODE_PRIVATE);
        amongus = getActivity().getSharedPreferences("title", Context.MODE_PRIVATE);
        titles = sp.getString("title", "");
        UserUUID = sp.getString("UUID", "");
        long messageTime = new Date().getTime();

        //pulls the message time as well as their id
//        mDatabase.child("palisade").child(titles).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//
//            }
//        });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.message_prompt, null);

        builder.setView(view)
                .setTitle("Your Message")

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = editTextMessage.getText().toString();
                        Log.d("amongus", mDatabase.child("palisade").child(titles).get().toString());


//                        PostsContents postsContents = new PostsContents(message, null, UserUUID);
                        //add if statement to check if UserUUID is equal to the post id if it is then can't reply
                        //that means that we have to get the message time as well as the data to put a reply to the message.
//                        mDatabase.child("palisade").child(titles).child(String.valueOf(messageTime)).setValue(postsContents);
                        listener.applyTexts(message);

                    }
                });
        editTextMessage = view.findViewById(R.id.user_message);

        return builder.create();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try {
            listener = (UserMessageListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "null");
        }
    }

    public interface UserMessageListener{
        void applyTexts(String message);
    }
}
