package it.droidcon.databinding.contact_3;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import it.droidcon.databinding.BR;

public class ContactInfo extends BaseObservable {
    private String message;

    private boolean messageAvailable;

    @Bindable
    public String getMessage() {
        return message;
    }

    @Bindable
    public boolean isMessageAvailable() {
        return messageAvailable;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);
    }

    public void setMessageAvailable(boolean messageAvailable) {
        this.messageAvailable = messageAvailable;
        notifyPropertyChanged(BR.messageAvailable);
    }
}
