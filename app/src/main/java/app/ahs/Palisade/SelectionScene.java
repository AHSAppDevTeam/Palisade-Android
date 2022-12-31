package app.ahs.Palisade;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Objects;
import java.util.UUID;

public class SelectionScene extends AppCompatActivity implements View.OnClickListener {

    public static final String TOPIC_NAME_ID = "topicNameID";
    ActionBar textchange;
    Button natureButton;
    Intent intentPosts;
    String UserUUID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_scene);
        Objects.requireNonNull(getSupportActionBar()).hide();
        natureButton = findViewById(R.id.nature_button);
        intentPosts = new Intent(this, PostsMenu.class);
        textchange = getSupportActionBar();

//        SharedPreferences sp = getApplicationContext().getSharedPreferences("UUID", Context.MODE_PRIVATE);
//        UserUUID = sp.getString("UUID", "");


        Intent intent = getIntent();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nature_button:
                textchange.setTitle((String) "Nature");
                break;
            case R.id.sports_button:
                textchange.setTitle((String) "Sports");
                break;
            case R.id.art_button:
                textchange.setTitle((String) "Art");
                break;
            case R.id.dating_button:
                textchange.setTitle((String) "Dating");
                break;
            case R.id.feelings_button:
                textchange.setTitle((String) "Feelings");
                break;
            case R.id.food_button:
                textchange.setTitle((String) "Food");
                break;
            case R.id.gaming_button:
                textchange.setTitle((String) "Gaming");
                break;
            case R.id.work_button:
                textchange.setTitle((String) "Work");
                break;
        }
        intentPosts.putExtra(PostsMenu.topicNameID, textchange.getTitle());
//        Log.d("amongus", UserUUID);
        startActivity(intentPosts);

    }
}