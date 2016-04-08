package it.droidcon.databinding.data;

import android.os.Parcel;
import android.os.Parcelable;

public class TeamScore implements Parcelable {
    private final String name;
    private final int goals;

    public TeamScore(String name, int goals) {
        this.name = name;
        this.goals = goals;
    }

    protected TeamScore(Parcel in) {
        name = in.readString();
        goals = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(goals);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TeamScore> CREATOR = new Creator<TeamScore>() {
        @Override
        public TeamScore createFromParcel(Parcel in) {
            return new TeamScore(in);
        }

        @Override
        public TeamScore[] newArray(int size) {
            return new TeamScore[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }
}
