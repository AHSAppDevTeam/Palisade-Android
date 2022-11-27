package app.ahs.Palisade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class selection_scene extends AppCompatActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_scene);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    TextView textchange = findViewById(R.id.topAppBar);
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nature_button:
                textchange.setText((String) "Nature");
                break;
            case R.id.sports_button:
                textchange.setText((String) "Sports");
                break;
            case R.id.art_button:
                textchange.setText((String) "Art");
                break;
            case R.id.dating_button:
                textchange.setText((String) "Dating");
                break;
            case R.id.feelings_button:
                textchange.setText((String) "Feelings");
                break;
            case R.id.food_button:
                textchange.setText((String) "Food");
                break;
            case R.id.gaming_button:
                textchange.setText((String) "Gaming");
                break;
            case R.id.work_button:
                textchange.setText((String) "Work");
                break;
        }
        Intent i = new Intent(this, posts_menu.class);
        startActivity(i);
    }
}