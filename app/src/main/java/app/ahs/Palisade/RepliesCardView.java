package app.ahs.Palisade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class RepliesCardView extends AppCompatActivity {
    private ArrayList<RepliesInfo> RepliesInfoList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.replies_menu);
        recyclerView = findViewById(R.id.reply_recycler_view);
        RepliesInfoList = new ArrayList();

        setReplyInfo();
        setAdapter();

    }

    private void setAdapter() {
        RepliesAdapter adapter = new RepliesAdapter(RepliesInfoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setReplyInfo() {
        //Change to firebase's replies
        RepliesInfoList.add(new RepliesInfo("reply1"));
        RepliesInfoList.add(new RepliesInfo("reply2"));
    }


}