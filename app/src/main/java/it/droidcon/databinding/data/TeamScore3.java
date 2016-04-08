package it.droidcon.databinding.data;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

public class TeamScore3 extends BaseObservable {
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableInt goals = new ObservableInt();
    //...
}
