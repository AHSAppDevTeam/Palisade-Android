package app.ahs.Palisade;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class RepliesDialog extends AppCompatDialogFragment {
    private TextView replyUser;
    private TextView reply;
    private Button showReplies;
    SharedPreferences sp;
    String UserUUID;
    PostsContents postsContents;

    public RepliesDialog(PostsContents position) {
        this.postsContents = position;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        PostsMenu postsMenu = new PostsMenu();


        sp = getActivity().getSharedPreferences("UUID", Context.MODE_PRIVATE);
        UserUUID = sp.getString("UUID", "");

//        if (UserUUID.equals(postsContents.getUser())){
//            LayoutInflater inflater = getActivity().getLayoutInflater();
//            View view = inflater.inflate(R.layout.replies_display, null);
//
//            builder.setView(view)
//                    .setTitle("Replies")
//                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    });
//            replyUser = view.findViewById(R.id.reply_username);
//            reply = view.findViewById(R.id.reply_reply);
//
//
//        }
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.replies_display, null);

        builder.setView(view)
                .setTitle("Replies")
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        replyUser = view.findViewById(R.id.reply_username);
        reply = view.findViewById(R.id.reply_reply);
        return builder.create();
    }
}
