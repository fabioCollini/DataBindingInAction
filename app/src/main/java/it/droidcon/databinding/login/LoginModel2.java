package it.droidcon.databinding.login;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Parcel;
import android.os.Parcelable;

public class LoginModel2 implements Parcelable {
    public final ObservableField<String> userName;

    public final ObservableField<String> password;

    public final ObservableBoolean sendVisible;

    public LoginModel2() {
        userName = new ObservableField<>("");
        password = new ObservableField<>("");
        sendVisible = new ObservableBoolean();
    }

    protected LoginModel2(Parcel in) {
        userName = (ObservableField<String>) in.readSerializable();
        password = (ObservableField<String>) in.readSerializable();
        sendVisible = new ObservableBoolean();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(userName);
        dest.writeSerializable(password);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LoginModel2> CREATOR = new Creator<LoginModel2>() {
        @Override
        public LoginModel2 createFromParcel(Parcel in) {
            return new LoginModel2(in);
        }

        @Override
        public LoginModel2[] newArray(int size) {
            return new LoginModel2[size];
        }
    };
}
