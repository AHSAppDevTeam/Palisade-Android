package app.ahs.Palisade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class testRecyclerAdapter extends RecyclerView.Adapter<testRecyclerAdapter.MyViewHolder> {
    private ArrayList<testRecycler> titleList;

    public testRecyclerAdapter(ArrayList<testRecycler> titleList){
        this.titleList = titleList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView bodyInfo;
        private TextView titleInfo;

        public MyViewHolder(final View view){
            super(view);
            bodyInfo = view.findViewById(R.id.testBody);
            titleInfo = view.findViewById(R.id.testTitle);
        }
    }

    @NonNull
    @Override
    public testRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_activity_data, parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull testRecyclerAdapter.MyViewHolder holder, int position) {
        String title = titleList.get(position).getTitle();
        holder.titleInfo.setText(title);
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }
}
