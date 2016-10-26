package it.droidcon.databinding.question_viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Parcel;
import android.os.Parcelable;

public class QuestionModel implements Parcelable {

    public final ObservableField<String> answer;

    public final ObservableInt countdown;

    public final ObservableBoolean sendEnabled;

    public QuestionModel() {
        countdown = new ObservableInt(10);
        sendEnabled = new ObservableBoolean();
        answer = new ObservableField<>("");
    }

    protected QuestionModel(Parcel in) {
        countdown = in.readParcelable(ObservableInt.class.getClassLoader());
        sendEnabled = in.readParcelable(ObservableBoolean.class.getClassLoader());
        answer = (ObservableField<String>) in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(countdown, flags);
        dest.writeParcelable(sendEnabled, flags);
        dest.writeSerializable(answer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionModel> CREATOR = new Creator<QuestionModel>() {
        @Override
        public QuestionModel createFromParcel(Parcel in) {
            return new QuestionModel(in);
        }

        @Override
        public QuestionModel[] newArray(int size) {
            return new QuestionModel[size];
        }
    };

    public int decrementCountdown() {
        int value = countdown.get() - 1;
        countdown.set(value);
        return value;
    }
}
