package com.usirooms.usirooms;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by costanzavolpini on 19/05/16.
 */
public class Credit extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        builder.setMessage("Costanza Volpini\nMarco Tollini" +
                "\nMichele Lustro\nThomas Del Prete")
                .setTitle("Credits")
                .setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //nothing
                    }
                })
                    .setNegativeButton("", new DialogInterface.OnClickListener(){
                        public void onClick (DialogInterface dialog, int id){
                            //nothing
                        }
        });
        return builder.create();
    }
}
