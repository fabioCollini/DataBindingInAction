package it.droidcon.databinding.contact_2;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

/**
 * Created by fabiocollini on 26/03/16.
 */
public class ContactInfo {
    public final ObservableField<String> message = new ObservableField<>();

    public final ObservableBoolean messageAvailable = new ObservableBoolean();
}
