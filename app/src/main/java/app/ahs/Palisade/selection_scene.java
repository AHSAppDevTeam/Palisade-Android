package app.ahs.Palisade;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class selection_scene extends AppCompatActivity implements View.OnClickListener {

    TextView textchange = findViewById(R.id.topAppBar);

    @SuppressLint({"NonConstantResourceId"})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nature_button:
                textchange.setText((String)"Nature");
            case R.id.sports_button:
                textchange.setText((String)"Sports");
            case R.id.art_button:
                textchange.setText((String)"Art");
            case R.id.dating_button:
                textchange.setText((String)"Dating");
            case R.id.feelings_button:
                textchange.setText((String)"Feelings");
            case R.id.food_button:
                textchange.setText((String)"Food");
            case R.id.gaming_button:
                textchange.setText((String)"Gaming");
            case R.id.work_button:
                textchange.setText((String)"Work");
        }
        Intent i = new Intent(this, posts_menu.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_scene);
        Objects.requireNonNull(getSupportActionBar()).hide();


    }




}