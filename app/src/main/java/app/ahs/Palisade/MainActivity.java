package app.ahs.Palisade;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_scene);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        mAuth = FirebaseAuth.getInstance();
        UUID.randomUUID().toString();
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(this, selection_scene.class);
            startActivity(intent);
            finish();
        }, 3000);

    }











}