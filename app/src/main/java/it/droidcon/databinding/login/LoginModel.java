package it.droidcon.databinding.login;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import it.droidcon.databinding.BR;

public class LoginModel extends BaseObservable implements Parcelable {
    private String userName = "";

    private String password = "";

    public LoginModel() {
    }

    protected LoginModel(Parcel in) {
        userName = in.readString();
        password = in.readString();
    }


    @Bindable public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
        notifyPropertyChanged(BR.sendVisible);
    }

    @Bindable public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
        notifyPropertyChanged(BR.sendVisible);
    }

    @Bindable public boolean isSendVisible() {
        return !userName.isEmpty() && !password.isEmpty();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(password);
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
