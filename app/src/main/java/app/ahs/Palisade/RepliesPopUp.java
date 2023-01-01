package app.ahs.Palisade;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RepliesPopUp extends AppCompatActivity {
    private Button showReplies;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materical_card_row);

        showReplies = findViewById(R.id.btn_replies);
        showReplies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showReplies();
            }
        });
    }

    public void showReplies(){
        RepliesDialog repliesDialog = new RepliesDialog();
        repliesDialog.show(getSupportFragmentManager(), "example dialog");
    }
}
