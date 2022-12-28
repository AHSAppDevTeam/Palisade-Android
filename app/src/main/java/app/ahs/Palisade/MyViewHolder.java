package app.ahs.Palisade;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Button btn_reply;
    private OnItemClickListener listener;

    public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
        super(itemView);
        btn_reply = itemView.findViewById(R.id.btn_reply);
        this.listener = listener;
        btn_reply.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        listener.onItemClick(getAdapterPosition());

    }
}
