package app.ahs.Palisade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RecyclerViewTest extends AppCompatActivity {


    DatabaseReference databaseReference;
    ArrayList<RecyclerViewTestClass> amongus;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_test);


        amongus = new ArrayList<>();
        recyclerView = findViewById(R.id.RecyclerViewTest);
        RecyclerViewTestAdapter recyclerViewTestAdapter = new RecyclerViewTestAdapter(this, amongus);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerViewTestAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        databaseReference = FirebaseDatabase.getInstance().getReference("test");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                amongus.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    RecyclerViewTestClass recyclerViewTestClass = dataSnapshot.getValue(RecyclerViewTestClass.class);
                    amongus.add(recyclerViewTestClass);
                }
                recyclerViewTestAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}