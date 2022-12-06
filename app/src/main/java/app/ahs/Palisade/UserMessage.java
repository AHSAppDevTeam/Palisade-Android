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

public class UserMessage extends AppCompatDialogFragment {
    private EditText editTextMessage;
    private UserMessageListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.message_prompt, null);

        builder.setView(view)
                .setTitle("Your Message")

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = editTextMessage.getText().toString();
                        listener.applyTexts(message);

                    }
                });
        editTextMessage = view.findViewById(R.id.user_message);

        return builder.create();
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        try {
            listener = (UserMessageListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "null");
        }
    }

    public interface UserMessageListener{
        void applyTexts(String message);
    }
}
