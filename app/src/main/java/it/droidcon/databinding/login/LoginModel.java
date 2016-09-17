package it.droidcon.databinding.login;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Parcel;
import android.os.Parcelable;

public class LoginModel implements Parcelable {
    public final ObservableField<String> userName;

    public final ObservableField<String> password;

    public final ObservableBoolean sendVisible;

    public LoginModel() {
        userName = new ObservableField<>("");
        password = new ObservableField<>("");
        sendVisible = new ObservableBoolean();
    }

    protected LoginModel(Parcel in) {
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

    public static final Creator<LoginModel> CREATOR = new Creator<LoginModel>() {
        @Override
        public LoginModel createFromParcel(Parcel in) {
            return new LoginModel(in);
        }

        @Override
        public LoginModel[] newArray(int size) {
            return new LoginModel[size];
        }
    };
}
