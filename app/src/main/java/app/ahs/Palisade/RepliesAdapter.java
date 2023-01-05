package app.ahs.Palisade;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RepliesAdapter extends RecyclerView.Adapter<RepliesAdapter.MyViewHolder> {

    ArrayList<RepliesContents> repliesList;
    Context context;
    OnRepliesItemClickListener listener;

    public RepliesAdapter(ArrayList<RepliesContents> repliesList, Context context, OnRepliesItemClickListener listener ){
        this.repliesList = repliesList;
        this.context = context;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RepliesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.replies_display, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RepliesAdapter.MyViewHolder holder, int position) {
        String reply = repliesList.get(position).getReply();
        holder.replies.setText(reply);
    }

    @Override
    public int getItemCount() {
        return repliesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView replies;
        Button btn_chat;

        public MyViewHolder(final View view){
            super(view);
            replies = view.findViewById(R.id.reply_reply);
            btn_chat = view.findViewById(R.id.btn_chat);
            btn_chat.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onChatClicked(this.getLayoutPosition());
        }
    }
}
