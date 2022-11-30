package app.ahs.Palisade;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Date;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_scene);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        long messageID = new Date().getTime();
        Log.d("amongus",String.valueOf(messageID));

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(this, SelectionScene.class);
            startActivity(intent);
            finish();
        }, 3000);

    }











}