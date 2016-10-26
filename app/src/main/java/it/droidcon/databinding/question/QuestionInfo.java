package it.droidcon.databinding.question;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

public class QuestionInfo {
    public final ObservableField<String> answer = new ObservableField<>("");

    public final ObservableInt countdown = new ObservableInt(10);

    public final ObservableBoolean sendEnabled = new ObservableBoolean();

    public int decrementCountdown() {
        int value = countdown.get() - 1;
        countdown.set(value);
        return value;
    }
}
