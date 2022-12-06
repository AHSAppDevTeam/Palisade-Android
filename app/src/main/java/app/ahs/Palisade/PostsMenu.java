package app.ahs.Palisade;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Date;

public class PostsMenu extends AppCompatActivity {
    public static final String topicNameID = "topicNameID";

    private SwipeRefreshLayout swipeRefreshLayout;
    DatabaseReference mDatabase;
    private RecyclerView recyclerView;
    ArrayList<PostsContents> list;
    PostsAdapter postsAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_menu);
        MaterialToolbar AppBarPosts = findViewById(R.id.topAppBarPosts);
        MaterialButton ReplyBtn = findViewById(R.id.btn_reply);
        swipeRefreshLayout = findViewById(R.id.swipelayout);
//        MaterialButton DeleteBtn = findViewById;

        setSupportActionBar(AppBarPosts);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });


        Intent intent = getIntent();
        String title = intent.getStringExtra(topicNameID);

        String UUID = intent.getStringExtra("UUID_OF_USER");

        AppBarPosts.setTitle(title);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Gets the Firebase Database
        mDatabase = FirebaseDatabase.getInstance().getReference("Palisade");


        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance().getReference().child(title).limitToLast(50);

        list = new ArrayList<>();
        recyclerView.setAdapter(postsAdapter);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    PostsContents postsContents = dataSnapshot.getValue(PostsContents.class);
                    list.add(postsContents);

                }
//                postsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

       //recyclerView.setAdapter(postsAdapter);

        //set up if delete = user that posted have if not user that posted show invisble and not clickable


        //set up reply button and also and for replys have a button to talk to user if it is the user that posted the post

        //should lead to the chatting menu between the users
        //chatting between users HAVE to send UUID

        //Make sure to put extra of what their uuid is when pulling the posts


        //add posts button


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };





        AppBarPosts.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PostsMenu.this, SelectionScene.class);
                startActivity(i);
            }
        });


    }

}