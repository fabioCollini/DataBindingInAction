package it.droidcon.databinding.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import it.droidcon.databinding.BR;

public class TeamScore2 extends BaseObservable {
    private String name;
    private int goals;

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public int getGoals() {
        return goals;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setGoals(int goals) {
        this.goals = goals;
        notifyPropertyChanged(BR.goals);
    }
}
