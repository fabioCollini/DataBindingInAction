package it.droidcon.databinding.e6_viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import it.droidcon.databinding.data.MatchResult;
import it.droidcon.databinding.data.MatchResultLoader;
import rx.Scheduler;

public class MatchResultViewModel {
    private final MatchResultLoader matchResultLoader;

    private final SnackbarManager snackbarManager;

    public final ObservableField<MatchResult> result = new ObservableField<>();

    public final ObservableBoolean loading = new ObservableBoolean();
    private Scheduler ioScheduler;
    private Scheduler uiScheduler;

    public MatchResultViewModel(MatchResultLoader matchResultLoader, SnackbarManager snackbarManager,
                                Scheduler ioScheduler, Scheduler uiScheduler, MatchResult result) {
        this.matchResultLoader = matchResultLoader;
        this.snackbarManager = snackbarManager;
        this.ioScheduler = ioScheduler;
        this.uiScheduler = uiScheduler;
        this.result.set(result);
    }

    public void reload() {
        loading.set(true);
        matchResultLoader.load()
                .subscribeOn(ioScheduler)
                .observeOn(uiScheduler)
                .subscribe(result -> {
                    loading.set(false);
                    this.result.set(result);
                }, t -> {
                    loading.set(false);
                    snackbarManager.showError(t.getMessage());
                });
    }
}
