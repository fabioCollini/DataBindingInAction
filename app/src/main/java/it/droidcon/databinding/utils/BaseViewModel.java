package it.droidcon.databinding.utils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import it.codingjam.lifecyclebinder.DefaultLifeCycleAware;

public abstract class BaseViewModel<M extends Parcelable> extends DefaultLifeCycleAware<Object> {

    private static final String MODEL = "MODEL";

    protected M model;

    @Override public final void onCreate(Object view, Bundle savedInstanceState, Intent intent, Bundle arguments) {
        if (savedInstanceState != null) {
            model = savedInstanceState.getParcelable(MODEL);
        } else {
            model = createModel(arguments);
        }
        onCreate(savedInstanceState == null);
    }

    protected abstract M createModel(Bundle arguments);

    public void onCreate(boolean firstStart) {
    }

    @Override public final void onStart(Object view) {
        onStart();
    }

    public void onStart() {
    }

    @Override public final void onResume(Object view) {
        onResume();
    }

    public void onResume() {
    }

    @Override public final boolean hasOptionsMenu(Object view) {
        return hasOptionsMenu();
    }

    public boolean hasOptionsMenu() {
        return false;
    }

    @Override public final void onCreateOptionsMenu(Object view, Menu menu, MenuInflater inflater) {
        onCreateOptionsMenu(menu, inflater);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    @Override public final boolean onOptionsItemSelected(Object view, MenuItem item) {
        return onOptionsItemSelected(item);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override public final void onPause(Object view) {
        onPause();
    }

    public void onPause() {
    }

    @Override public final void onStop(Object view) {
        onStop();
    }

    public void onStop() {
    }

    @Override public final void onSaveInstanceState(Object view, Bundle bundle) {
        bundle.putParcelable(MODEL, model);
        onSaveInstanceState(bundle);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override public final void onDestroy(Object view, boolean changingConfigurations) {
        onDestroy(changingConfigurations);
    }

    public void onDestroy(boolean changingConfigurations) {
    }

    @Override public final void onActivityResult(Object view, int requestCode, int resultCode, Intent data) {
        onActivityResult(requestCode, resultCode, data);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public M getModel() {
        return model;
    }
}
