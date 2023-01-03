package app.ahs.Palisade;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RepliesPopUp extends AppCompatActivity {
    SharedPreferences sp;
    String UserUUID;
    DatabaseReference mDatabase;
    DatabaseReference RepliesDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materical_card_row);
        sp = getApplicationContext().getSharedPreferences("UUID", Context.MODE_PRIVATE);
        UserUUID = sp.getString("UUID", "");
        Button showReplies = findViewById(R.id.btn_replies);
        PostsMenu postsMenu = new PostsMenu();

        mDatabase = FirebaseDatabase.getInstance().getReference("palisade/" + postsMenu.getTitle());
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    PostsContents postsContents = dataSnapshot.getValue(PostsContents.class);
                    if (UserUUID.equals(postsContents.getUser())) {
                        showReplies.setVisibility(View.VISIBLE);
                    } else {
                        showReplies.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        })

    }

    public void setInvisible() {
        View showReplies = findViewById(R.id.btn_replies);
        showReplies.setVisibility(View.INVISIBLE);
    }
    public void setVisible() {
        View showReplies = findViewById(R.id.btn_replies);
        showReplies.setVisibility(View.VISIBLE);
    }

//    public void showReplies(){
//        RepliesDialog repliesDialog = new RepliesDialog();
//        repliesDialog.show(getSupportFragmentManager(), "example dialog");
//    }
}
