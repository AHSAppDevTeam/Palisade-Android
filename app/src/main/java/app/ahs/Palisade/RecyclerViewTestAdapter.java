package app.ahs.Palisade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewTestAdapter extends RecyclerView.Adapter<RecyclerViewTestAdapter.ViewHolder> {

    Context context;
    ArrayList<RecyclerViewTestClass> amongus;


    public RecyclerViewTestAdapter(Context context, ArrayList<RecyclerViewTestClass> amongus) {
        this.context = context;
        this.amongus = amongus;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.material_card_view, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerViewTestClass recyclerViewTestClass =  amongus.get(position);
        holder.body.setText(recyclerViewTestClass.getBody());
        holder.title.setText(recyclerViewTestClass.getTitle());

    }

    @Override
    public int getItemCount() {
        return amongus.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_titles_recycler);
            body = itemView.findViewById(R.id.txt_body_recycler);
        }
    }

}
