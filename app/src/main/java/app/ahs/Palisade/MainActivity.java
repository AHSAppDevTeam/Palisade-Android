package app.ahs.Palisade;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_scene);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        UUID uuid = UUID.randomUUID();
        Log.d("amongus", String.valueOf(uuid));


//        long messageID = new Date().getTime();
//        Log.d("amongus",String.valueOf(messageID));



        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(this, SelectionScene.class);
            intent.putExtra(SelectionScene.TOPIC_NAME_ID, uuid);
            startActivity(intent);
            finish();
        }, 3000);

    }











}