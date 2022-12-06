package app.ahs.Palisade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.auth.data.model.User;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ChattingMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText edtMessageInput;
    private TextView txtChattingWith;
    private ProgressBar progressBar;
    private ImageView imgSendMessage;

    private ArrayList<Message> messages;

    private MessageAdapter messageAdapter;

    String UserUUID;
    String chatRoomID;
    String RoommateUUID;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatting_menu);

        MaterialToolbar topAppBarChat = findViewById(R.id.topAppBarChat);


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        topAppBarChat.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ChattingMenu.this, SelectionScene.class);
                startActivity(i);
            }
        });

//        UserUUID = getIntent().getStringExtra();


        recyclerView = findViewById(R.id.recyclerMessages);
        edtMessageInput = findViewById(R.id.edtText);
        txtChattingWith = findViewById(R.id.txtChattingWith);
        progressBar = findViewById(R.id.progress_messages);
        imgSendMessage = findViewById(R.id.imgSendMessage);



        txtChattingWith.setText("Anonymous");

        MainActivity mainActivity = new MainActivity();


        messages = new ArrayList<>();

        imgSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference("messages/"+chatRoomID).push().setValue(new Message(mainActivity.getUserUUID()));
                edtMessageInput.setText("");
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.setAdapter(messageAdapter);



        setUpChatRoom();



        
    }

    private void setUpChatRoom() {
        FirebaseDatabase.getInstance().getReference("palisade/messages").addListenerForSingleValueEvent(new ValueEventListener() {
            MainActivity mainActivity = new MainActivity();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String UserUUID = String.valueOf(mainActivity.getUserUUID());
                if (UserUUID.compareTo(RoommateUUID) > 0) {
                    chatRoomID = UserUUID + RoommateUUID;
                } else if (RoommateUUID.compareTo(UserUUID) == 0) {
                    chatRoomID = UserUUID + RoommateUUID;
                } else {
                    chatRoomID = RoommateUUID + UserUUID;
                }
                attachMessageListener(chatRoomID);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void attachMessageListener(String chatRoomID) {
        FirebaseDatabase.getInstance().getReference("message/" + chatRoomID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                messages.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()) {
                    messages.add(dataSnapshot.getValue(Message.class));
                }
                messageAdapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(messages.size()-1);
                recyclerView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }



















}