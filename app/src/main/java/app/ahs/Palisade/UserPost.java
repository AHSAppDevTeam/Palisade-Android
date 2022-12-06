package app.ahs.Palisade;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class UserPost extends AppCompatDialogFragment {
    private EditText editPost;
    private NewPostsListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.new_post, null);

        builder.setView(view)
                .setTitle("Your Post")

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String post = editPost.getText().toString();
                        listener.applyTexts(post);

                    }
                });

        editPost = view.findViewById(R.id.post);

        return builder.create();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try {
            listener = (NewPostsListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "null");
        }
    }

    public interface NewPostsListener{
        void applyTexts(String post);
    }
}
