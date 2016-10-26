package it.droidcon.databinding.question_viewmodel;

import android.os.Bundle;
import it.droidcon.databinding.utils.BaseRxViewModel;
import it.droidcon.databinding.utils.ConnectionChecker;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

import static it.droidcon.databinding.RxDataBinding.toRx;

public class QuestionViewModel extends BaseRxViewModel<QuestionModel> {

    private ConnectionChecker connectionChecker;

    public QuestionViewModel(ConnectionChecker connectionChecker) {
        this.connectionChecker = connectionChecker;
    }

    @Override protected QuestionModel createModel(Bundle arguments) {
        return new QuestionModel();
    }

    @Override protected void onCreateViewModel(CompositeSubscription subscription) {
        subscription.add(
                Observable.interval(1, TimeUnit.SECONDS)
                        .limit(10)
                        .subscribe(l -> model.decrementCountdown())
        );
    }

    @Override protected void onStart(CompositeSubscription subscription) {
        subscription.add(Observable.combineLatest(
                toRx(model.answer),
                toRx(model.countdown),
                connectionChecker.getConnectionStatus(),
                (answer, countdown, connected) ->
                        !answer.isEmpty() && countdown > 0 && connected
        ).subscribe(model.sendEnabled::set));
    }
}
