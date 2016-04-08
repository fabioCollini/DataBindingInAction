package it.droidcon.databinding.utils;

import android.support.design.widget.Snackbar;

import it.cosenonjaviste.mv2m.ActivityHolder;

public class SnackbarManager {
    public void showError(ActivityHolder activityHolder, String message) {
        Snackbar.make(activityHolder.getActivity().findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
    }
}
