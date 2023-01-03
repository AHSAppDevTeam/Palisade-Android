package app.ahs.Palisade;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    //use Shared Preferences to make UUID that is final for different devices and that will then be used for messaging and posts
    //without the UUID it won't work

    SharedPreferences sp;
    String uuidString = UUID.randomUUID().toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_scene);

        sp = getSharedPreferences("UUID", Context.MODE_PRIVATE);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

//        long messageID = new Date().getTime();
//        Log.d("amongus",String.valueOf(messageID));

//        Log.d("amongus", String.valueOf(uuid));


        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(this, SelectionScene.class);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("UUID", uuidString);
            editor.apply();
            Log.d("amongus", uuidString);
            startActivity(intent);
            finish();
        }, 3000);

    }

    public String getUserUUID() {
        return sp.getString("UUID", "");
    }













}