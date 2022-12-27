package app.ahs.Palisade;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.firebase.ui.auth.data.model.User;
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
    String UserUUID;
    SharedPreferences titles;

    MainActivity mainActivity = new MainActivity();




    MaterialCardView materialCardView;
//    PostsContents postsContents = new PostsContents();



//    public void Delete(View view){
//        Log.d("amongus", (UserUUID + " User") );
//        //delete message if user id is the same
////        materialCardView.setVisibility(View.INVISIBLE);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_menu);
        Intent intent = getIntent();
        MaterialToolbar AppBarPosts = findViewById(R.id.topAppBarPosts);
        recyclerView = findViewById(R.id.recyclerview);
//        UserUUID = String.valueOf(mainActivity.getUserUUID());
//        SharedPreferences sp = getApplicationContext().getSharedPreferences("UUID", Context.MODE_PRIVATE);
//        UserUUID = sp.getString("UUID", "");





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
                Log.d("amongus", (UserUUID + " User"));
                newPost();
            }
        });

        //Getting the title of the
//        titles = getSharedPreferences("title", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = titles.edit();
//        editor.putString("title", title);
//        editor.apply();
//        Log.d("amongus", (UserUUID + " UUID"));



        String title = intent.getStringExtra(topicNameID);
        AppBarPosts.setTitle(title);
        title = title.toLowerCase(Locale.ROOT);
        Log.d("amongus", title);

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

    public void openMessage() {
        UserMessage userMessage = new UserMessage();
        userMessage.show(getSupportFragmentManager(), "example dialog");
    }


    public void newPost() {
        UserPost userPost = new UserPost();
        userPost.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String message) {
//        question.setText(message);
        //upload to firebase instead of setting anything to text because that message will then popular the view or upload using the functions inside the classes for each post and message


    }
    public void Reply(View view) {
        Log.d("amongus", (UserUUID + " User"));
        openMessage();
    }

}