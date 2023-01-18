package app.ahs.Palisade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.firestore.auth.User;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class testActivity extends AppCompatActivity {
    private ArrayList <testRecycler> titleList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        recyclerView = findViewById(R.id.recyclerview);
        titleList = new ArrayList<>();

        setTitleInfo();
        setAdapter();
    }

    private void setAdapter() {
         testRecyclerAdapter adapter = new testRecyclerAdapter(titleList);
         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
         recyclerView.setLayoutManager(layoutManager);
         recyclerView.setItemAnimator(new DefaultItemAnimator());
         recyclerView.setAdapter(adapter);
    }

    private void setTitleInfo() {
        titleList.add(new testRecycler("Bob"));
    }
}