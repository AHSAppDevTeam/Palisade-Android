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



public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder>{

    Context context;
    OnItemClickListener listener;
    ArrayList<PostsContents> list;

    public PostsAdapter(ArrayList<PostsContents> list, Context context, OnItemClickListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate layout
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.materical_card_row, parent,false);
//        ViewHolder viewHolder = new ViewHolder(view, listener);
        return new MyViewHolder(view, listener);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //assigning new variables to the dynamic list
        PostsContents postsContents = list.get(position);
        holder.message.setText(postsContents.getMessage());
//        holder.user.setText(postsContents.getUser());
//        holder.messageID.setText(postsContents.getMessageID());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView message;
        TextView user;
        TextView messageID;
        Button reply;


        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            message = itemView.findViewById(R.id.question);
            reply = itemView.findViewById(R.id.btn_reply);
            reply.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(this.getLayoutPosition());

        }
    }



}
