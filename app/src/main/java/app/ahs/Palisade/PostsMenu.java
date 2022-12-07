package app.ahs.Palisade;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Date;

public class PostsMenu extends AppCompatActivity implements UserMessage.UserMessageListener, UserPost.NewPostsListener{
    private Button reply;
    private Button new_post;
    private TextView question;

    public static final String topicNameID = "topicNameID";
    private SwipeRefreshLayout swipeRefreshLayout;
    DatabaseReference mDatabase;
    private RecyclerView recyclerView;
    ArrayList<PostsContents> list;
    PostsAdapter postsAdapter;

    @Override
    public void applyTexts(String post) {
        question.setText(post);
    }


    MaterialCardView materialCardView;

    public void Delete(View view){
        materialCardView.setVisibility(View.INVISIBLE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_menu);
        MaterialToolbar AppBarPosts = findViewById(R.id.topAppBarPosts);
        swipeRefreshLayout = findViewById(R.id.swipelayout);
//        MaterialButton DeleteBtn = findViewById;

        setSupportActionBar(AppBarPosts);

        materialCardView = (MaterialCardView) findViewById(R.id.card);
        question = (TextView) findViewById(R.id.question);
        reply = (Button) findViewById(R.id.btn_reply);
        new_post = (Button) findViewById(R.id.new_message);

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMessage();
            }
        });

        new_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newPost();
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

    public void openMessage() {
        UserMessage userMessage = new UserMessage();
        userMessage.show(getSupportFragmentManager(), "example dialog");
    }

    public void newPost() {
        UserPost userPost = new UserPost();
        userPost.show(getSupportFragmentManager(), "example dialog");
    }

}