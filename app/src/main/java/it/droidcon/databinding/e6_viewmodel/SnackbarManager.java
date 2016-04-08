package it.droidcon.databinding.e6_viewmodel;

import android.app.Activity;
import android.support.design.widget.Snackbar;

public class SnackbarManager {

    private Activity activity;

    public SnackbarManager(Activity activity) {
        this.activity = activity;
    }

    public void showError(String message) {
        Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }
}
