package app.ahs.Palisade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RepliesCardView extends AppCompatActivity implements OnRepliesItemClickListener {
    private ArrayList<RepliesContents> RepliesList;
    private RecyclerView recyclerView;
    DatabaseReference repliesDatabase;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.replies_menu);
        PostsMenu postsMenu = new PostsMenu();
        mDatabase = FirebaseDatabase.getInstance().getReference("palisade/" + postsMenu.getTitles());
        Log.d("amongus", postsMenu.getTitles() + " hello");
        recyclerView = findViewById(R.id.reply_recycler_view);
        RepliesList = new ArrayList<>();
        RepliesAdapter adapter = new RepliesAdapter(RepliesList, this, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
//        setAdapter();


        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String amongus = dataSnapshot.getKey();
                    repliesDatabase = FirebaseDatabase.getInstance().getReference("palisade/"+ postsMenu.getTitles() + amongus + "/replies");
                    repliesDatabase.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            RepliesList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                String KeyUser = amongus;
                                Log.d("amongus", KeyUser);
                                Log.d("amongus", dataSnapshot.toString());
                                RepliesContents repliesContents = dataSnapshot.getValue(RepliesContents.class);
                                repliesContents.setKey(KeyUser);
                                RepliesList.add(repliesContents);
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



    }

    private void setAdapter() {
        RepliesAdapter adapter = new RepliesAdapter(RepliesList, this, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onChatClicked(int position) {
        //create new chat room which get the user to send for the messaging system
    }

//    private void setReplyInfo() {
//        //Change to firebase's replies
//
//
//
//
//
//    }


}