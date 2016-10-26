package it.droidcon.databinding.question;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import it.droidcon.databinding.R;
import it.droidcon.databinding.databinding.QuestionBinding;
import rx.Observable;
import rx.Subscription;

import static it.droidcon.databinding.RxDataBinding.toRx;

public class QuestionActivity extends AppCompatActivity {

    private QuestionInfo info;

    private Subscription subscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QuestionBinding binding = DataBindingUtil.setContentView(this, R.layout.question);
        info = new QuestionInfo();
        binding.setInfo(info);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override public void run() {
                int newValue = info.decrementCountdown();
                if (newValue > 0) {
                    handler.postDelayed(this, 1000);
                }
            }
        }, 1000);
    }

    @Override protected void onStart() {
        super.onStart();
        subscription = Observable.combineLatest(
                toRx(info.answer),
                toRx(info.countdown),
                (answer, countdown) ->
                        !answer.isEmpty() && countdown > 0
        ).subscribe(info.sendEnabled::set);
    }

    @Override protected void onStop() {
        super.onStop();
        subscription.unsubscribe();
    }
}
