package it.droidcon.databinding.question_viewmodel;

import android.os.Bundle;
import it.droidcon.databinding.login.BaseRxViewModel;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

import static it.droidcon.databinding.RxDataBinding.toRx;

public class QuestionViewModel extends BaseRxViewModel<QuestionModel> {

    @Override protected QuestionModel createModel(Bundle arguments) {
        return new QuestionModel();
    }

    @Override protected void onCreate(CompositeSubscription subscription) {
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
                (answer, countdown) ->
                        !answer.isEmpty() && countdown > 0
        ).subscribe(model.sendEnabled::set));
    }
}
