package app.ahs.Palisade;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

    private ArrayList<Message> messages;
    private Context context;

    public MessageAdapter(ArrayList<Message> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_holder,parent,false);
        return new MessageHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        holder.txtMessage.setText(messages.get(position).getContent());

        ConstraintLayout constraintlayout = holder.ccll;

        MainActivity mainActivity = new MainActivity();
        Log.d("amongus", String.valueOf(mainActivity.getUserUUID()));


        if (messages.get(position).getSender().equals(mainActivity.getUserUUID())) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintlayout);
            constraintSet.clear(R.id.profileCardView, ConstraintSet.LEFT);
            constraintSet.clear(R.id.txtMessage, ConstraintSet.LEFT);
            constraintSet.connect(R.id.profileCardView,ConstraintSet.RIGHT, R.id.ccLayout,ConstraintSet.RIGHT, 0);
            constraintSet.connect(R.id.txtMessage,ConstraintSet.RIGHT, R.id.profileCardView,ConstraintSet.LEFT, 0);
            constraintSet.applyTo(constraintlayout);


        } else {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintlayout);
            constraintSet.clear(R.id.profileCardView, ConstraintSet.RIGHT);
            constraintSet.clear(R.id.txtMessage, ConstraintSet.RIGHT);
            constraintSet.connect(R.id.profileCardView,ConstraintSet.LEFT, R.id.ccLayout,ConstraintSet.LEFT, 0);
            constraintSet.connect(R.id.txtMessage,ConstraintSet.LEFT, R.id.profileCardView,ConstraintSet.RIGHT, 0);
            constraintSet.applyTo(constraintlayout);
        }


    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MessageHolder extends RecyclerView.ViewHolder {
        ConstraintLayout ccll;
        TextView txtMessage;
        ImageView profImage;
        public MessageHolder(@NonNull View itemView) {
            super(itemView);

            ccll = itemView.findViewById(R.id.ccLayout);
            txtMessage = itemView.findViewById(R.id.txtMessage);
            profImage = itemView.findViewById(R.id.small_profile_img);

        }
    }
}
