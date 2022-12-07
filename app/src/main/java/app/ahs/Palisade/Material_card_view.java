package app.ahs.Palisade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Material_card_view extends AppCompatActivity {

    Button reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materical_card_row);

        reply = (Button) findViewById(R.id.btn_reply);

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMessage();
            }
        });


    }

    public void openMessage() {
        UserMessage userMessage = new UserMessage();
        userMessage.show(getSupportFragmentManager(), "example dialog");
    }


}