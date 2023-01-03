package app.ahs.Palisade;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Button btn_reply;
    private OnItemClickListener listener;
    private Button btn_show_replies;

    public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
        super(itemView);
        btn_reply = itemView.findViewById(R.id.btn_reply);
        btn_show_replies = itemView.findViewById(R.id.btn_replies);
        this.listener = listener;
        btn_reply.setOnClickListener(this);
        btn_show_replies.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == btn_reply) {
            listener.onItemClick(getAdapterPosition(), "btn_reply");
        } else if (view == btn_show_replies)
            listener.onItemClick(getAdapterPosition(), "btn_show_replies");

    }
}
