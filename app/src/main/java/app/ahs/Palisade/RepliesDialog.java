package app.ahs.Palisade;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RepliesDialog extends AppCompatDialogFragment implements OnRepliesItemClickListener {
    private TextView replyUser;
    private TextView reply;
    private Button showReplies;
    SharedPreferences sp;
    String UserUUID;
    PostsContents postsContents;
    RecyclerView recyclerView;
    ArrayList<RepliesContents> repliesList;
    DatabaseReference mDatabase;
    DatabaseReference repliesDatabase;


    public RepliesDialog(PostsContents position) {
        this.postsContents = position;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        PostsMenu postsMenu = new PostsMenu();

        sp = getActivity().getSharedPreferences("UUID", Context.MODE_PRIVATE);
        UserUUID = sp.getString("UUID", "");

//        if (UserUUID.equals(postsContents.getUser())){
//            LayoutInflater inflater = getActivity().getLayoutInflater();
//            View view = inflater.inflate(R.layout.replies_display, null);
//
//            builder.setView(view)
//                    .setTitle("Replies")
//                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    });
//            replyUser = view.findViewById(R.id.reply_username);
//            reply = view.findViewById(R.id.reply_reply);
//
//
//        }
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.replies_menu, null);

        recyclerView =  view.findViewById(R.id.reply_recycler_view);

        repliesList = new ArrayList<>();
        RepliesAdapter adapter = new RepliesAdapter(repliesList, getContext(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        mDatabase = FirebaseDatabase.getInstance().getReference("palisade/" + postsMenu.getTitles());
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String amongus = dataSnapshot.getKey();
                    repliesDatabase = FirebaseDatabase.getInstance().getReference("palisade/"+ postsMenu.getTitles() + amongus + "/replies");
                    repliesDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            repliesList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                Log.d("amongus", amongus);
                                Log.d("amongus", dataSnapshot.toString());
                                RepliesContents repliesContents = dataSnapshot.getValue(RepliesContents.class);
                                repliesContents.setKey(amongus);
                                repliesList.add(repliesContents);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        builder.setView(view)
                .setTitle("Replies")
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }

    @Override
    public void onChatClicked(int position) {

    }
}
