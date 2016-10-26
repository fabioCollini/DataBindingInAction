package it.droidcon.databinding.question;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import it.droidcon.databinding.BR;

public class QuestionInfo2 extends BaseObservable {
    private String answer = "";

    private int countdown = 10;

    public int decrementCountdown() {
        --countdown;
        notifyPropertyChanged(BR.countdown);
        return countdown;
    }

    @Bindable public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
        notifyPropertyChanged(BR.answer);
    }

    @Bindable public int getCountdown() {
        return countdown;
    }

    @Bindable
    public boolean isSendEnabled() {
        return !answer.isEmpty() && countdown > 0;
    }
}
