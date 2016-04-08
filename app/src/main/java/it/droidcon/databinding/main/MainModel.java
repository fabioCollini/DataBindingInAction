package it.droidcon.databinding.main;

import android.databinding.ObservableParcelable;
import android.os.Parcel;
import android.os.Parcelable;

import it.droidcon.databinding.data.MatchResult;

public class MainModel implements Parcelable {
    public final ObservableParcelable<MatchResult> matchResult;

    public MainModel() {
        matchResult = new ObservableParcelable<>();
    }

    protected MainModel(Parcel in) {
        matchResult = in.readParcelable(MatchResult.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(matchResult, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MainModel> CREATOR = new Creator<MainModel>() {
        @Override
        public MainModel createFromParcel(Parcel in) {
            return new MainModel(in);
        }

        @Override
        public MainModel[] newArray(int size) {
            return new MainModel[size];
        }
    };
}
