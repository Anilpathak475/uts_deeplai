package com.example.androidexamp.example.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.widget.Toast;

import com.example.androidexamp.example.R;


/**
 * Created by anilpathak on 05/09/17.
 */

public class UiUtils {
    public Activity activity;
    public int LOADER_DURATION = 1000;
    private Dialog dialog;

    public UiUtils(Activity activity) {
        this.activity = activity;
        dialog = new Dialog(activity);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.loader_dialog);
    }

    public void showProgressDialog() {
        dialog.show();
    }

    public void dismissDialog() {
        if (null != dialog) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    public void successPopup() {
        dialog.show();
    }

    public void shortToast(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    public void noInternetDialog() {
        if (activity == null) {
            return;
        }
        try {
            final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("No Internet Connection");
            builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");

            builder.setPositiveButton("Ok", (dialog, which) -> dialog.dismiss());

            builder.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
