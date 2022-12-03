package app.ahs.Palisade;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;

public class PostsMenu extends AppCompatActivity {
    public static final String topicNameID = "topicNameID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_menu);
        MaterialToolbar textchange = findViewById(R.id.topAppBar);


        Intent intent = getIntent();
        String title = intent.getStringExtra(topicNameID);

        textchange.setTitle(title);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PostsData[] postsData = new PostsData[]{
                new PostsData("Bob", "Test1"),
                new PostsData("John", "Test2"),
                new PostsData("Billy", "Test3"),
                new PostsData("Kevin", "Test4"),
        };

       PostsAdapter postsAdapter = new PostsAdapter(postsData, PostsMenu.this);
//       recyclerView.setAdapter(postsAdapter);

    }




}