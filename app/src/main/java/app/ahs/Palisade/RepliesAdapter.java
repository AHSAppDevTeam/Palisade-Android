package app.ahs.Palisade;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RepliesAdapter extends RecyclerView.Adapter<RepliesAdapter.MyViewHolder> {
    private ArrayList<RepliesInfo> RepliesInfoList;

    public RepliesAdapter(ArrayList<RepliesInfo> RepliesInfoList){
        this.RepliesInfoList = RepliesInfoList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView replies;

        public MyViewHolder(final View view){
            super(view);
            replies = view.findViewById(R.id.reply_reply);
        }
    }

    @NonNull
    @Override
    public RepliesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.replies_display, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RepliesAdapter.MyViewHolder holder, int position) {
        String reply = RepliesInfoList.get(position).getReply_reply();
        holder.replies.setText(reply);
    }

    @Override
    public int getItemCount() {
        return RepliesInfoList.size();
    }
}
