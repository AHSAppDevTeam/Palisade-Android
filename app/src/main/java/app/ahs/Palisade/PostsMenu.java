package app.ahs.Palisade;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
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
import java.util.BitSet;
import java.util.Date;
import java.util.Locale;

public class PostsMenu extends AppCompatActivity implements UserMessage.UserMessageListener, UserPost.NewPostsListener{
    private Button reply;
    private FloatingActionButton new_post;
    private TextView question;

    public static final String topicNameID = "topicNameID";
    private SwipeRefreshLayout swipeRefreshLayout;
    DatabaseReference mDatabase;
    RecyclerView recyclerView;
    ArrayList<PostsContents> list;
    PostsAdapter postsAdapter;


    @Override
    public void applyTexts(String message) {
        question.setText(message);

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
        recyclerView = findViewById(R.id.recyclerview);

        setSupportActionBar(AppBarPosts);

        new_post = (FloatingActionButton) findViewById(R.id.new_posts);

        AppBarPosts.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PostsMenu.this, SelectionScene.class);
                startActivity(i);
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



        title = title.toLowerCase(Locale.ROOT);

        list = new ArrayList<>();

        postsAdapter = new PostsAdapter(list, this);

        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(postsAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Gets the Firebase Database
        mDatabase = FirebaseDatabase.getInstance().getReference("palisade/" + title);


        mDatabase.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    PostsContents postsContents = dataSnapshot.getValue(PostsContents.class);
                    list.add(postsContents);
                }
                postsAdapter.notifyDataSetChanged();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        AppBarPosts.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PostsMenu.this, SelectionScene.class);
                startActivity(i);
            }
        });
    }


    public void newPost() {
        UserPost userPost = new UserPost();
        userPost.show(getSupportFragmentManager(), "example dialog");
    }

}