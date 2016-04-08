package it.droidcon.databinding.main;

import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;

import it.cosenonjaviste.mv2m.rx.RxViewModel;
import it.cosenonjaviste.mv2m.rx.SchedulerManager;
import it.droidcon.databinding.data.MatchResultLoader;
import it.droidcon.databinding.utils.SnackbarManager;

public class MainViewModel extends RxViewModel<Void, MainModel> {
    public final ObservableBoolean loading = new ObservableBoolean();

    private final MatchResultLoader matchResultLoader;
    private final SnackbarManager snackbarManager;

    public MainViewModel(SchedulerManager schedulerManager, MatchResultLoader matchResultLoader, SnackbarManager snackbarManager) {
        super(schedulerManager);
        this.matchResultLoader = matchResultLoader;
        this.snackbarManager = snackbarManager;
    }

    @NonNull
    @Override
    protected MainModel createModel() {
        return new MainModel();
    }

    public void reload() {
        model.matchResult.set(null);
        subscribe(
                loading::set,
                matchResultLoader.load(),
                f -> model.matchResult.set(f),
                t -> snackbarManager.showError(activityHolder, t.getMessage())
        );
    }
}
