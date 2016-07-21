package uc.daelim.com.dmoney.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import uc.daelim.com.dmoney.R;

/**
 * Created by dilky on 2016-07-20.
 */
public class ErrorUtils {
    public static void AlertException(Activity atvt, String expMessage, Exception e) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(atvt);
        dialog.setTitle(atvt.getString(R.string.common_text_error));
        dialog.setMessage(expMessage);
        dialog.setNeutralButton(R.string.common_text_confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
        e.printStackTrace();
    }
}
