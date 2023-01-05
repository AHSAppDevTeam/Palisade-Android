package app.ahs.Palisade;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RepliesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final OnRepliesItemClickListener listener;
    private Button btn_show_replies;


    public RepliesViewHolder(@NonNull View itemView, OnRepliesItemClickListener listener) {
        super(itemView);
        btn_show_replies = itemView.findViewById(R.id.btn_replies);
        this.listener = listener;
        btn_show_replies.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        listener.onChatClicked(getAdapterPosition());
    }
}
